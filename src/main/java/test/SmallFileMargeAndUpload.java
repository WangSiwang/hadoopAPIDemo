package test;

import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class SmallFileMargeAndUpload {



}

class FileIncloudFilter implements PathFilter{

    private String regex;

    

    public boolean accept(Path arg0) {
        arg0.toString().matches(regex)
        return false;
    }

}
class FileOutCloudFilter implements PathFilter {

    public boolean accept(Path path) {
        return false;
    }
}
