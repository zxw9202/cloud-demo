package com.zxw.genarator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.zxw.genarator.contants.GenConstants;


public class GenerateCode {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setAuthor(System.getenv("USERNAME"));
        // 生成文件的路径
        gc.setOutputDir(projectPath + "/im-common/src/main/java");
        // 是否覆盖同名文件，默认是false
        gc.setFileOverride(false);
        // 是否打开资源管理器
        gc.setOpen(false);
        // 开启配置swagger
        gc.setSwagger2(true);
        // 设置时间格式
        gc.setDateType(DateType.ONLY_DATE);
        gc.setIdType(IdType.ASSIGN_UUID);
        // XML ResultMap
        gc.setBaseResultMap(true);

        // 自定义文件命名
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(GenConstants.DRIVER_NAME);
        dsc.setUsername(GenConstants.USER_NAME);
        dsc.setPassword(GenConstants.PASSWORD);
        dsc.setUrl(GenConstants.DATA_SOURCE_BASE_URL);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        // 此处可以修改为你的表前缀
        strategy.setTablePrefix("");
        // 表名生成策略--下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 列名生成规则--下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(
                "video_order"
        );
        // 改为RestController
        strategy.setRestControllerStyle(true);
        // 开启使用Lombok
        strategy.setEntityLombokModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        // com.haier.platform.cosmo.datasource.base.entity
        pc.setParent("com.zxw");
        pc.setModuleName("baseuserskill");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
