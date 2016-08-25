package cloudaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CloudDownItem implements CommandActionCloud{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String file_name = request.getParameter("file_name");
		String file_path = request.getParameter("file_path");
		int i = file_path.lastIndexOf(".");
		String extension = null;
		if (i == -1){
			extension = "";
		}else{
		extension = file_path.substring(i);
		}

		        File downloadfile = new File(file_path);
		        if (downloadfile.exists() && downloadfile.isFile()) {
		            response.setContentType("application/octet-stream; charset=utf-8");
		            response.setContentLength((int) downloadfile.length());
		            OutputStream outputstream = null;
		            FileInputStream inputstream = null;
		            try {
		            	response.setHeader("Content-Disposition","attachment; filename=" + file_name+";");
		                outputstream = response.getOutputStream();
		                inputstream = new FileInputStream(downloadfile);
		                byte[] buffer = new byte[1024];  
		                int length = 0;  
		                while((length = inputstream.read(buffer)) > 0) {
		                    outputstream.write(buffer,0,length);  
		                } 
		                
		            } catch (Exception e) {
		                e.printStackTrace();
		            } finally {
		                try {
		                    if (inputstream != null){
		                        inputstream.close();
		                    }
		                    outputstream.flush();
		                    outputstream.close();   
		                    
		                } catch (Exception e2) {}
		            }
		        }else {
		            System.out.println("파일이 존재하지 않음");
		        }
		    
		
		/*다운임포트 끝*/

		return null;
	}
}
