package com.lanling.generator;

import com.lanling.generator.database.Database;
import com.lanling.generator.database.Field;
import com.lanling.generator.database.Table;
import com.lanling.generator.database.Type;
import com.lanling.utils.IntrospectUtil;

import java.util.List;

/**
 * The Class
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class Test {
    public static void main(String[] args) {
        Database database = IntrospectUtil.getTableList(0, "lanling", "jdbc:mysql://localhost:3306/lanling?useSSL=true", "root", "lanling");
        List<Table> tableList = database.getTableList();
        for (Table table:tableList) {
            System.out.println(table.getName());
            List<Field> fieldList = table.getFieldList();
            for (Field field:fieldList) {
                System.out.print(field.getName()+field.getType()+" ");
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void test(){
        System.out.println(Type.getType(-5).name());
    }
}
