import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * @author gaoxugang
 * @data 2021/12/19 0019 19:58
 * @description TODO
 */
public class HDFSApp {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.set("fs.defaultFS", "hdfs://192.168.1.103:9000");
        configuration.set("dfs.client.use.datanode.hostname","false");
        try {
            FileSystem fileSystem = FileSystem.newInstance(configuration);

            //上传文件
            fileSystem.mkdirs(new Path("/dave"));
            fileSystem.copyFromLocalFile(new Path("C:\\Users\\Administrator\\Desktop\\高欣冉.jpg"), new Path("/dave/gxg111.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
