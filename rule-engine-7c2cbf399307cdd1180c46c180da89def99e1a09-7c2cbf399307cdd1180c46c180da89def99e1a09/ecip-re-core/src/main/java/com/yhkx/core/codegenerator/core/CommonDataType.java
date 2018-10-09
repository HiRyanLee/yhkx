package com.yhkx.core.codegenerator.core;

import java.lang.reflect.Field;

/**
 * 在业务工程中，DB操作涉及到的数据类型有三种：
 * 数据库的SQL类型 -- JDBC数据类型（java.sql.Types） -- Java数据类型
 * 例如：VARCHAR/NVARCHAR -- VARCHAR -- String
 * 为什么需要这样做呢？由于数据库的SQL类型和Java的数据类型是不一致的，我们使用Java数据类型编写的业务代码需要存到使用SQL类型的数据时，就需要某种
 * 转换机制
 * 幸运的是，我们并不需要去关心实际的数据库的SQL类型，因为每个数据库对于同一个类型的明明不一样，比如大型二进制值的 SQL 类型，但 Oracle
 * 把这种类型叫做 LONG RAW，Sybase 把它叫做 IMAGE，Informix 却把它叫做 BYTE
 * 我们只根据现有的数据表来进行编程，至于转换的事情，交给JDBC来做，JDBC就要用到java.sql.Types来做
 * 这个类是原原本本从java.sql.Types复制过来的，为的是使用velocity自动编译成DAO代码
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class CommonDataType {

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BIT</code>.
     */
    public final static int BIT = -7;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>TINYINT</code>.
     */
    public final static int TINYINT = -6;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>SMALLINT</code>.
     */
    public final static int SMALLINT = 5;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>INTEGER</code>.
     */
    public final static int INTEGER = 4;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BIGINT</code>.
     */
    public final static int BIGINT = -5;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>FLOAT</code>.
     */
    public final static int FLOAT = 6;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>REAL</code>.
     */
    public final static int REAL = 7;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DOUBLE</code>.
     */
    public final static int DOUBLE = 8;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NUMERIC</code>.
     */
    public final static int NUMERIC = 2;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DECIMAL</code>.
     */
    public final static int DECIMAL = 3;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>CHAR</code>.
     */
    public final static int CHAR = 1;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>VARCHAR</code>.
     */
    public final static int VARCHAR = 12;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>LONGVARCHAR</code>.
     */
    public final static int LONGVARCHAR = -1;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DATE</code>.
     */
    public final static int DATE = 91;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>TIME</code>.
     */
    public final static int TIME = 92;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>TIMESTAMP</code>.
     */
    public final static int TIMESTAMP = 93;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BINARY</code>.
     */
    public final static int BINARY = -2;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>VARBINARY</code>.
     */
    public final static int VARBINARY = -3;

    /**
     * <p>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type
     * <code>LONGVARBINARY</code>.
     */
    public final static int LONGVARBINARY = -4;

    /**
     * <p>
     * The constant in the Java programming language that identifies the generic
     * SQL value <code>NULL</code>.
     */
    public final static int NULL = 0;

    /**
     * The constant in the Java programming language that indicates that the SQL
     * type is database-specific and gets mapped to a Java object that can be
     * accessed via the methods <code>getObject</code> and
     * <code>setObject</code>.
     */
    public final static int OTHER = 1111;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>JAVA_OBJECT</code>.
     *
     * @since 1.2
     */
    public final static int JAVA_OBJECT = 2000;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DISTINCT</code>.
     *
     * @since 1.2
     */
    public final static int DISTINCT = 2001;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>STRUCT</code>.
     *
     * @since 1.2
     */
    public final static int STRUCT = 2002;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>ARRAY</code>.
     *
     * @since 1.2
     */
    public final static int ARRAY = 2003;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BLOB</code>.
     *
     * @since 1.2
     */
    public final static int BLOB = 2004;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>CLOB</code>.
     *
     * @since 1.2
     */
    public final static int CLOB = 2005;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>REF</code>.
     *
     * @since 1.2
     */
    public final static int REF = 2006;

    /**
     * The constant in the Java programming language, somtimes referred to as a
     * type code, that identifies the generic SQL type <code>DATALINK</code>.
     *
     * @since 1.4
     */
    public final static int DATALINK = 70;

    /**
     * The constant in the Java programming language, somtimes referred to as a
     * type code, that identifies the generic SQL type <code>BOOLEAN</code>.
     *
     * @since 1.4
     */
    public final static int BOOLEAN = 16;

    // ------------------------- JDBC 4.0 -----------------------------------

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>ROWID</code>
     *
     * @since 1.6
     */
    public final static int ROWID = -8;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NCHAR</code>
     *
     * @since 1.6
     */
    public static final int NCHAR = -15;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NVARCHAR</code>.
     *
     * @since 1.6
     */
    public static final int NVARCHAR = -9;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>LONGNVARCHAR</code>
     * .
     *
     * @since 1.6
     */
    public static final int LONGNVARCHAR = -16;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NCLOB</code>.
     *
     * @since 1.6
     */
    public static final int NCLOB = 2011;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>XML</code>.
     *
     * @since 1.6
     */
    public static final int SQLXML = 2009;

    // --------------------------JDBC 4.2 -----------------------------

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type {@code REF CURSOR}.
     *
     * @since 1.8
     */
    public static final int REF_CURSOR = 2012;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type
     * {@code TIME WITH TIMEZONE}.
     *
     * @since 1.8
     */
    public static final int TIME_WITH_TIMEZONE = 2013;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type
     * {@code TIMESTAMP WITH TIMEZONE}.
     *
     * @since 1.8
     */
    public static final int TIMESTAMP_WITH_TIMEZONE = 2014;

    public static String getJdbcType(int code) {
        Field[] fields = CommonDataType.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (code == (int) field.get(null)) {
                    return field.getName();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
