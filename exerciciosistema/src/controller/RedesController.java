package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	private String identificaSistema() {
		String os = System.getProperty("os.name");
		String ver = System.getProperty("os.version");
		
		return os;
	}
	
	public void ip() {
		boolean sistema = identificaSistema().contains("Win");
		String proc = "";
		
		if (sistema == true) {
			proc = "ipconfig";
			String [] procArr = proc.split(" ");
			try {
				Process pro = Runtime.getRuntime().exec(procArr);
				BufferedReader buffer = new BufferedReader(new InputStreamReader(pro.getInputStream()));
				String linha = buffer.readLine();
				
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
			} catch (Exception e) {
				String msg = e.getMessage();
				//System.err.println(msg);
			}
				
		} else {
			proc = "ifconfig";
			String [] procArr = proc.split(" ");
			try {
				Process pro = Runtime.getRuntime().exec(procArr);
				InputStream input = pro.getInputStream();
				InputStreamReader leitor = new InputStreamReader(input);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				input.close();
			} catch (Exception e1) {
				String msg = e1.getMessage();
				//System.err.println(msg);
			}
		}

	}
	
	public void ping(){
		boolean sistema = identificaSistema().contains("Win");
		String proc = "";
		
		if (sistema == true) {
			proc = "ping -4 -n 10 www.google.com.br";
			String [] procArr = proc.split(" ");
			
			try {
				Process pro = Runtime.getRuntime().exec(procArr);
				BufferedReader buffer = new BufferedReader(new InputStreamReader(pro.getInputStream()));
				String linha = buffer.readLine();
				
				while (linha != null) {
					linha = buffer.readLine();
					
					if(linha.contains("Ave")) {
						System.out.println(linha);
					}
				}
				buffer.close();
						
			
			} catch (Exception e) {
				String msg = e.getMessage();
				//System.err.println(msg);
			}
				
		} else {
			proc = "ping -4 -n 10 www.google.com.br";
			String [] procArr = proc.split(" ");
			try {
				Process pro = Runtime.getRuntime().exec(procArr);
				InputStream input = pro.getInputStream();
				InputStreamReader leitor = new InputStreamReader(input);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					linha = buffer.readLine();
					if(linha.contains("avg")) {
						System.out.println(linha);
					}
				}
				
				buffer.close();
				leitor.close();
				input.close();
			} catch (Exception e1) {
				String msg = e1.getMessage();
				//System.err.println(msg);
			}
		}
		
	}
}
