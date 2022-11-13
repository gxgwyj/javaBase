import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * @author gaoxugang
 * @data 2022/11/13 0013 19:26
 * @description TODO
 */
public class HBaseApp {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        // 配置ZK的地址，通过ZK可以找到HBase
        conf.set("hbase.zookeeper.quorum", "192.168.202.128:2181");
        Connection connection = ConnectionFactory.createConnection(conf);


        Admin admin = connection.getAdmin();



        Table user = admin.getConnection().getTable(TableName.valueOf("user"));


        Get get = new Get("gaoxugang".getBytes());

        for (int i = 0; i < 20000000 ; i++) {
            Result rs = user.get(get);
            for(KeyValue keyValue: rs.list()){

                System.out.println("family :" + Bytes.toString(keyValue.getFamily()));//列簇名

                System.out.println("qualifier :"+ Bytes.toString(keyValue.getQualifier()));//列名

                System.out.println("value :"+Bytes.toString(keyValue.getValue()));//列对应的值

                System.out.println("timestamp :" +keyValue.getTimestamp());//数据最后更新时间
            }
        }

    }
}
