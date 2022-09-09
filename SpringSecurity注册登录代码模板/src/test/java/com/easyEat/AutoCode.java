package com.easyEat;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author BDsnake
 * @since 2022/9/9 9:48
 */
public class AutoCode {
    @Test
    public void ac(){
        //创建Generator对象
        AutoGenerator autoGenerator = new AutoGenerator();

        /***********数据源配置****************/
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://localhost/easy_eat?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8");
        dataSourceConfig.setUsername("xxxx");
        dataSourceConfig.setPassword("xxxxxxx");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);

        /***********全局配置****************/
        GlobalConfig globalConfig = new GlobalConfig();
        //获取当前系统目录usr.dir，然后后面跟自己的模块名和代码路径
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        globalConfig.setOpen(true);
        globalConfig.setAuthor("BDsnake");
        autoGenerator.setGlobalConfig(globalConfig);
//              开启swagger2注解
//        globalConfig.setSwagger2(true);

        /***********包配置****************/
        PackageConfig packageConfig = new PackageConfig();
        //父package
        packageConfig.setParent("com.easyEat");
        //本身package名，可以不设置
//                packageConfig.setModuleName("generator");
        //controller包名
        packageConfig.setController("controller");
        //service包名
        packageConfig.setService("service");
        //serviceImpl包名
        packageConfig.setServiceImpl("service.impl");
        //mapper包名
        packageConfig.setMapper("mapper");
        //实体类包名
        packageConfig.setEntity("entity");
        autoGenerator.setPackageInfo(packageConfig);

        /***********配置策略****************/
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        //设置自动生成哪张表，不设置默认生成全部表
        strategyConfig.setInclude("sys_user");
        //设置去除表名"t_"前缀
//                strategyConfig.setTablePrefix("t_");
        //逻辑删除字段设置
        strategyConfig.setLogicDeleteFieldName("deleted");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();
    }
}