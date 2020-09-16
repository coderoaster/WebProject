<%@page import="org.apache.commons.net.ftp.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

	FTPClient ftp = null;

	try
	{
		 String FilePath="";
	
	    ftp = new FTPClient();
	    ftp.setControlEncoding("UTF-8");
	    ftp.connect("192.168.0.76");			// 접속할 ip
	    ftp.login("ftpuser", "1111");	// 접속할 아이디, 비밀번
	   
	    ftp.setFileType(FTPClient.BINARY_FILE_TYPE); //	파일 깨짐 방지
	    
	    // ftp 저장할 장소 (루트의 imgs 폴더)
	    ftp.changeWorkingDirectory("/imgs/");
	    
	   	// 저장할 파일 선택
	    File uploadFile = new File("/Users/tj/Documents/background.jpg");
	    FileInputStream fis = null;
	   
	    try
	    {
	        fis = new FileInputStream(uploadFile);
	        
	        // ftp 서버에 파일을 저장한다. (저장한 이름, 파일)
	        boolean isSuccess = ftp.storeFile(uploadFile.getName(), fis);
	        if (isSuccess)
	        {
	            System.out.println("Upload Success");
	        }
	    } catch (IOException ex) {
	        System.out.println(ex.getMessage());
	    } finally {
	        if (fis != null)
	            try
	            {
	                fis.close();
	            } catch (IOException ex) {}
	    }
	    ftp.logout();
	    
	} catch (SocketException e) {
	    System.out.println("Socket:" + e.getMessage());
	} catch (IOException e)	{
	    System.out.println("IO:" + e.getMessage());
	} finally {
	    if (ftp != null && ftp.isConnected())
	    {
	        try
	        {
	            ftp.disconnect();
	        } catch (IOException e)
	        {
	        }
	    }
	}

%>