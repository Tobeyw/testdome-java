import java.util.ArrayList;
import java.util.Arrays;

public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
public void cd2(String newPath) {
        int i=0;
        String[] newPathArray=newPath.split("/"); 
        String[] pathArray=this.path.split("/");
        int newPathLength=newPathArray.length;
       for (Object elem : pathArray) {
        System.out.println(elem);
       }
        ArrayList pathList=new ArrayList(); //this cannot be an array, since it needs to have variable size
        for(int j=1; j<pathArray.length; j++){
        	pathList.add(pathArray[j]);
        }
        
        if(newPathArray[0].equals("")){
        	//absolute pathname
        	pathList.clear();
        	pathList.add(newPathArray[1]);
        	i=i+2;
        }
        
        while(i<newPathLength){
        	int k=pathList.size()-1;
        	if(newPathArray[i].equals("..")){
        		//parent directory
        		pathList.remove(k);
        	}
        	else{
        		//adding a child directory
        		pathList.add(newPathArray[i]);
        	}
        	i++;
        }
       
        StringBuilder updatedPath=new StringBuilder();
        for(int l=0; l<pathList.size(); l++){
        	updatedPath.append("/"+pathList.get(l));
        }
        
        //System.out.println(updatedPath);
        this.path=updatedPath.toString();
        
        
    }
    public void cd1(String newPath) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");
       String[] arr = this.path.split("/");

       String[] cdArr = newPath.split("/");
     
       int count =0;
      for (int i = 0; i < cdArr.length; i++) {
          if (cdArr[i].equals("..")){
            count++;
          }
      }
      String[] temp = Arrays.copyOfRange(arr, 0, arr.length-count);

      String p = "";
      for (String elem : temp) {
          p +=elem +"/";
      }
      
      for (int i = count; i < cdArr.length; i++) {
        p +=cdArr[i] +"/";
      }
  
      this.path = p;
    }


    public void cd(String newPath) {
        // 分割路径为段
        String[] currentParts = this.path.split("/");
        String[] newParts = newPath.split("/");

        // 使用一个栈结构来模拟路径导航
        java.util.Stack<String> pathStack = new java.util.Stack<>();

        // 将当前路径加入栈中
        for (String part : currentParts) {
            if (!part.isEmpty()) {
                pathStack.push(part);
            }
        }

        // 解析新路径
        for (String part : newParts) {
            if (part.equals("..")) {
                // 返回上一级目录
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                // 如果是正常目录名，加入栈中
                pathStack.push(part);
            }
        }

        // 构建新的路径
        StringBuilder newPathBuilder = new StringBuilder();
        for (String part : pathStack) {
            newPathBuilder.append("/").append(part);
        }

        // 如果栈为空，返回根目录 "/"
        this.path = newPathBuilder.length() > 0 ? newPathBuilder.toString() : "/";
    }
    
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("x/../z");
        System.out.println(path.getPath());
    }
}