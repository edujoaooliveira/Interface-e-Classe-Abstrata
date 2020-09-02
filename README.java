# Interface-e-Classe-Abstrata
package br.univille.poo.logger;

import java.io.File;
import java.io.FileWriter;


class Main {
    public static void main(String[] args) {
    	
    	
    	
    	Logger   loggerC = LoggerFactory.getInstance().createConsoleLogger();
        Logger loggerF =LoggerFactory.getInstance().createFileLogger();
        
        
        
        loggerC.mensagem("Iniciou o Sistema");
        loggerC.mensagem("Executando o Sistema");
        loggerC.mensagem("Finalizou o Sistema");
       
        loggerF.mensagem("Iniciou o Sistema");
        loggerF.mensagem("Executando o Sistema");
        loggerF.mensagem("Finalizou o Sistema");
      
      
        
    }
    
    
}

package br.univille.poo.logger;

class ConsoleLogger implements Logger{

	@Override
	public void mensagem(String mensagem) {
		 System.out.println(mensagem);
		
	}



	
	


}
package br.univille.poo.logger;

import java.io.File;
import java.io.FileWriter;

class FileLogger implements Logger{

	@Override
	public void mensagem(String mensagem) {
		try{
	 		
	 	    File arquivo = new File("arquivo.txt");
	 	    FileWriter writer = new FileWriter(arquivo,true);
	 	    writer.write(mensagem + "\n");
	 	    writer.close();
	 	}catch(Exception e){
	 		
	 	    e.printStackTrace();
	 	}
		
	}
	
	
 	

	 }
   
package br.univille.poo.logger;

public interface Logger {
	
	public void mensagem(String mensagem);
	

	
	

}

package br.univille.poo.logger;

 public abstract class LoggerFactory {
	
	 abstract Logger  createConsoleLogger();
	 
	 abstract Logger createFileLogger();
	
	
	 protected LoggerFactory(){};
	 
	 private static LoggerFactory instance ;
	
	   
	    public static  LoggerFactory getInstance()
	    {
	        if(instance==null)
	        {
	            instance= new LoggerFactoryConcreta();
	        }
	        return instance;
	    }
	   
	}
	 
package br.univille.poo.logger;

 class LoggerFactoryConcreta extends LoggerFactory {

	@Override
	public Logger createConsoleLogger() {
		
		return  new ConsoleLogger();
	}

	@Override
	public Logger createFileLogger() {
		
		return new FileLogger();
	}

}
