package com.pgleon.cboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.base.Strings;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: leon
 * @Date: 2019-07-09 14:32
 * @Description: DruidDataSource配置属性列表
 */
@EnableConfigurationProperties
public class DruidDataSourceConfig {

    /**
     * 链接数据库的URL
     */
    private String url;
    private String username;
    private String password;

    /**
     * 初始化时建立物理连接的个数。初始化发生在显示调用init方法，
     * 或者第一次getConnection时
     */
    private int initialSize = 1;

    /**
     * 物理连接初始化的时候执行的sql
     */
    private String connectInitSqls;

    /**
     * 最大连接池数量
     */
    private int maxActive = 20;

    /**
     * 最小连接池数量
     */
    private int minIdle = 1;
    /**
     * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，
     * 并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
     */
    private long maxWait = 6000;

    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。
     * 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
     */
    private String validationQuery = "SELECT 1";

    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean testOnBorrow = true;
    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean testOnReturn = false;
    /**
     * 建议配置为true，不影响性能，并且保证安全性。
     * 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     */
    private boolean testWhileIdle = true;

    /**
     * 有两个含义：
     * 1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvictableIdleTimeMillis则关闭物理连接。
     * 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
     */
    private long timeBetweenEvictionRunsMillis = 60000;
    /**
     * 连接保持空闲而不被驱逐的最小时间
     */
    private long minEvictableIdleTimeMillis = 300000;

    /**
     * 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
     */
    private boolean poolPreparedStatements = false;

    /**
     * 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
     * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
     */
    private int maxPoolPreparedStatementPerConnectionSize = -1;

    public static DruidDataSource build(DruidDataSourceConfig config) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(config.getUrl());
        druidDataSource.setUsername(config.getUsername());
        druidDataSource.setPassword(config.getPassword());
        druidDataSource.setValidationQuery(config.getValidationQuery());
        if (!Strings.isNullOrEmpty(config.getConnectInitSqls())) {
            List<String> connectInitSql = new ArrayList<>();
            connectInitSql.add(config.getConnectInitSqls());
            druidDataSource.setConnectionInitSqls(connectInitSql);
        }
        druidDataSource.setInitialSize(config.getInitialSize());
        druidDataSource.setMaxActive(config.getMaxActive());
        druidDataSource.setMinIdle(config.getMinIdle());
        druidDataSource.setMaxWait(config.getMaxWait());
        druidDataSource.setMinEvictableIdleTimeMillis(config.getMinEvictableIdleTimeMillis());
        druidDataSource.setTimeBetweenEvictionRunsMillis(
                config.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setTestOnBorrow(config.isTestOnBorrow());
        druidDataSource.setTestOnReturn(config.isTestOnReturn());
        druidDataSource.setTestWhileIdle(config.isTestWhileIdle());

        druidDataSource.setPoolPreparedStatements(config.isPoolPreparedStatements());
        druidDataSource.setMaxOpenPreparedStatements(config.getMaxPoolPreparedStatementPerConnectionSize());
        return druidDataSource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public boolean isPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getConnectInitSqls() {
        return connectInitSqls;
    }

    public void setConnectInitSqls(String connectInitSqls) {
        this.connectInitSqls = connectInitSqls;
    }
}
