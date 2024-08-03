import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String folderPath = "/Users/edy/Downloads/y2k";
        Map<Integer,Integer>ss=new HashMap<>();
        int n = 10;
        
        // 获取文件夹中所有图片文件的列表
        File folder = new File(folderPath);
        //File[] imageFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg")); // 过滤出以.jpg结尾的文件

        //File[] imageFiles = folder.listFiles((dir, name) ->
        //        name.toLowerCase().endsWith(".jpg") ||
        //                name.toLowerCase().endsWith(".txt") ||
        //                name.toLowerCase().endsWith(".jpeg"));

        File[] imageFiles = folder.listFiles();

        if (imageFiles != null) {
            // 遍历图片文件列表，进行重命名
            for (int i = 0; i < imageFiles.length; i++) {
                File oldFile = imageFiles[i];
                String newName = "Y2K_" + (i + 1)+".jpg" ; // 新文件名，格式为image_1.jpg、image_2.jpg等
                File newFile = new File(folderPath, newName);

                // 执行重命名操作
                boolean renameSuccess = oldFile.renameTo(newFile);
                if (renameSuccess) {
                    System.out.println("Renamed: " + oldFile.getName() + " -> " + newName);
                } else {
                    System.out.println("Failed to rename: " + oldFile.getName());
                }
            }
        } else {
            System.out.println("No image files found in the folder.");
        }
    }
}