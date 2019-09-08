package com.yunqi.utils;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yunqi
 * @createdTime: 2019-09-07
 * 描述
 */
public class DbUtils {
    public static void main(String[] args) throws Exception {
        getBuild();
    }
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/yunqi?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String ONE_TAB = "  ";
    private static final String TWO_TAB = "      ";
    private static final String RN = "\r\n";
    public static Map<String, String> sqlMap_TO_JavaMap = new HashMap<>();

    static {
        sqlMap_TO_JavaMap.put("TINYINT", "Byte");
        sqlMap_TO_JavaMap.put("SMALLINT", "Short");
        sqlMap_TO_JavaMap.put("INT UNSIGNED", "Integer");
        sqlMap_TO_JavaMap.put("INT", "Integer");
        sqlMap_TO_JavaMap.put("BIGINT", "Long");
        sqlMap_TO_JavaMap.put("CHAR", "String");
        sqlMap_TO_JavaMap.put("VARCHAR", "String");
        sqlMap_TO_JavaMap.put("TIMESTAMP", "Timestamp");
        sqlMap_TO_JavaMap.put("DATETIME", "Date");
    }

    private static Connection getConnection() throws Exception {
        Class.forName("com.yunqi.utils.DbUtils");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    private static void getBuild() throws Exception {
        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables("yunqi", null, null, null);
        while (tables.next()) {
            // String dataBaseName = tables.getString(1);数据库名称
            //  String s = tables.getString(2);未知
            //表名
            String tableName = tables.getString(3);
            String className = "public class " + getClassName(tableName) + "{" +RN;
            ResultSet columns = metaData.getColumns("yunqi", "",
                    tableName, null);
            String fieldName = "";
            String setMethod = "";
            String getMethod = "";
            while (columns.next()) {
                String columnName = getFieldName(columns.getString("COLUMN_NAME"));
                String dataType = sqlMap_TO_JavaMap.get(columns.getString("TYPE_NAME"));
                fieldName += ONE_TAB + "private " + dataType + " " + columnName + ";" + RN;
                setMethod += ONE_TAB + "public void set" + getMethodField(columnName) +  "(" + dataType + " " + columnName
                        + ") {" + RN + TWO_TAB + "this." + columnName + " = " + columnName + ";"
                        + RN + ONE_TAB + "}" + RN;
                getMethod += ONE_TAB + "public " + dataType + " get" + getMethodField(columnName) + " () {"
                        + RN + TWO_TAB + "return " + columnName + ";" + RN + ONE_TAB + "}" + RN;
            }
            createJavaFile(getClassName(tableName), className, fieldName, setMethod, getMethod);

        }

    }

    private static void createJavaFile (String tableName, String className, String fieldName, String setMethod, String getMethod) throws IOException {
        String path = "D:\\codeRepository\\yunqi-master\\mybatis\\src\\main\\java\\com\\yunqi\\bean";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileClass = new File(path + "/" + tableName + ".java");
        if (!fileClass.exists()) {
            fileClass.createNewFile();
            FileWriter fileWriter = new FileWriter(fileClass, true);
            fileWriter.append("package com.yunqi.bean;" + RN);
            if (fieldName.contains("Date")) {
                fileWriter.append("import java.util.Date;" + RN);
            }
            if (fieldName.contains("Timestamp")) {
                fileWriter.append("import java.sql.Timestamp;" + RN);
            }
            fileWriter.append(className)
                    .append(fieldName)
                    .append(setMethod)
                    .append(getMethod)
                    .append("}");
            fileWriter.flush();
            fileWriter.close();
        }
    }

    private static String getMethodField(String methodField) {
        return methodField.substring(0, 1).toUpperCase() + methodField.substring(1, methodField.length());
    }

    private static String getClassName(String tableName) {
        String[] classNames = tableName.split("_");
        String className = "";
        for (String s : classNames) {
            className += s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
        }
        return className;
    }

    private static String getFieldName(String columnName) {
        String[] fieldNames = columnName.split("_");
        String fieldName = "";
        for (String s : fieldNames) {
            if (s == fieldNames[0]) {
                fieldName += s.substring(0, 1).toLowerCase() + s.substring(1, s.length()).toLowerCase();
            } else {
                fieldName += s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
            }
        }
        return fieldName;
    }



}
