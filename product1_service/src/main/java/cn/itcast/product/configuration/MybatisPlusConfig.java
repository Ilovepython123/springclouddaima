package cn.itcast.product.configuration;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sun.misc.PerformanceLogger;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MybatisPlusConfig {

    public static ThreadLocal<String> myTableName = new ThreadLocal<String>();

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        //下面是多租户的配置代码
//        ArrayList<ISqlParser> sqlParserList = new ArrayList<ISqlParser>();
//        TenantSqlParser tenantSqlParser = new TenantSqlParser();
//        tenantSqlParser.setTenantHandler(new TenantHandler(){
//            @Override
//            public String getTenantIdColumn() {
//                return "manager_id";
//            }
//            @Override
//            public net.sf.jsqlparser.expression.Expression getTenantId(boolean where) {
////                return new LongValue(1422374343481466884l);
//                return new StringValue("corp_qdyb");
//            }
//            @Override
//            public boolean doTableFilter(String tableName){
//                    if("user_id".equals(tableName)) {
//                        return true;
//                    }
//
//                return false;
//            }
//        });
//        sqlParserList.add(tenantSqlParser);
//        PaginationInterceptor paginationlnterceptor = new PaginationInterceptor();
//        paginationlnterceptor.setSqlParserList(sqlParserList);
//        return paginationlnterceptor;


        //下面是动态表的配置代码
        ArrayList<ISqlParser> sqlParserList = new ArrayList<ISqlParser>();
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        Map<String, ITableNameHandler> tableNameHandlerMap = new HashMap<>();
        tableNameHandlerMap.put("user_id",new ITableNameHandler(){
            @Override
            public String dynamicTableName(MetaObject metaObject, String sql, String tableName) {
                return myTableName.get();
            }
        });
        dynamicTableNameParser.setTableNameHandlerMap(tableNameHandlerMap);
        sqlParserList.add(dynamicTableNameParser);
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {


            @Override
            public boolean doFilter(MetaObject metaObject) {

                return false;
            }
        });
        return paginationInterceptor;
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }


    /**
     * @Author lihuan
     * @Description //TODO 
     * @Date 16:56 2021/9/9
     * @Param []
     * @return org.springframework.aop.interceptor.PerformanceMonitorInterceptor
     **/
    
    @Bean
    @Profile({"dev","test"})
    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
        PerformanceMonitorInterceptor performanceMonitorInterceptor = new PerformanceMonitorInterceptor();
        return performanceMonitorInterceptor;
    }

}
