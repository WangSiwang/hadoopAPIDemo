package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;


public class HdfsDownUp {
	
	static FileSystem fs = null;
	static{
		System.setProperty("HADOOP_USER_NAME", "hadoop");
		try {
			fs = FileSystem.newInstance(new URI("hdfs://172.20.52.204:9000"), new Configuration());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] arg) throws Exception{
		
		//create();
		//mkdir();
		listfile();
	}
	
	private static void listfile() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Path dest = new Path("/");
		
		FileStatus[] listStatus = fs.listStatus(dest);
		for (FileStatus fileStatus : listStatus) {
			System.out.println(fileStatus);
		}
	}

	private static void mkdir() {
		// TODO Auto-generated method stub
		Path dest = new Path("/newdir");
		try {
			System.out.println(fs);
			fs.mkdirs(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void downloadFromdfs() throws Exception{
		FileSystem fs = FileSystem.newInstance(new URI("hdfs://172.20.52.204:9000"), new Configuration());
		
		Path src = new Path("/a.txt");
		
		FSDataInputStream in = fs.open(src);
		
		File file = new File("/a.txt");
		FileOutputStream out = new FileOutputStream(file);
		IOUtils.copyBytes(in, out, 4096, true);
		
		System.out.println("12");
		
	}
	
	public static void upload() throws Exception{
		FileSystem fs = FileSystem.newInstance(new URI("hdfs://172.20.52.204:9000"), new Configuration());
		
		Path src = new Path("e://delete.rar");
		Path dest = new Path("/");
		
		fs.copyFromLocalFile(false, src, dest);
		System.out.println("12");
	}
	
	public static void create() throws Exception{
		createFile();
	}

	private static void createFile() throws IOException, URISyntaxException {
		FileSystem fs = FileSystem.newInstance(new URI("hdfs://172.20.52.204:9000"), new Configuration());
		
		byte[] bytes = "kkk".getBytes();
		
		Path dest  = new Path("/KKK");
		FSDataOutputStream out = fs.create(dest);
		out.write(bytes);

		System.out.println("12");
	}
	
}
