package forza4;
import javax.swing.*;

//	jForza4 v0.6.2 by Rosario Terranova

public class Forza4 {
    private int tavoliere [][] = new int [6][7];  				//creazione matrice
    
            public Forza4() {
                for (int i=0;i<tavoliere.length;i++)
                    for (int j=0;j<tavoliere[i].length;j++)
                        tavoliere[i][j]=0; 						 //0 = pezzo nullo, 1 = pezzo rosso, 2 = pezzo verde
            }
            
            public void inserisciPezzoRosso(int x){
                loop: for (int i=5;i>=0;i--)
                            if (tavoliere[i][x-1] == 0){
                                tavoliere[i][x-1] = 1;
                                 break loop;
                            }
            }
            
            public void inserisciPezzoVerde(int x){
                loop: for (int i=5;i>=0;i--)
                            if (tavoliere[i][x-1] == 0){
                                tavoliere[i][x-1] = 2;
                                 break loop;
                            }
            }
            
            public int controllaPezzo(int x, int y){
            	return tavoliere[x][y];
            }
                          
            public void azzeraTavoliere(){
                for (int i=0;i<tavoliere.length;i++)
                    for (int j=0;j<tavoliere[i].length;j++)
                        tavoliere[i][j]=0;
                }
            
            public String getTavoliere(){
            	String displayT="";
                for (int i=0;i<tavoliere.length;i++){
                   for (int j=0;j<tavoliere[i].length;j++){
                	   displayT += tavoliere[i][j]+" ";
                	   if (j==6)
                       	displayT += '\n';
                   	}
                }	
                return displayT;
            }
            
            public boolean controlloVincita()
            {               
                boolean vincita=false;
		    
              //trova 4 orizzontali
                for (int i=5;i>=0;i--)
                	for (int j=0;j<4;j++){
                		if (tavoliere[i][j]==1 && tavoliere[i][j+1]==1 && tavoliere[i][j+2]==1 && tavoliere[i][j+3]==1)
                			vincita = true;
                	}
			
              //trova 4 verticali
                for (int i=0;i<3;i++)
                      for (int j=0;j<7;j++){		
                		 if (tavoliere[i][j]==1 && tavoliere[i+1][j]==1 && tavoliere[i+2][j]==1 && tavoliere[i+3][j]==1)
                			 vincita = true;
                      }
		      
              //trova 4 diagonali destre
                for (int j=0;j<4;j++){		
          		 	if (tavoliere[0][j]==1 && tavoliere[1][j+1]==1 && tavoliere[2][j+2]==1 && tavoliere[3][j+3]==1)
          		 		vincita = true;
          		 	else if (tavoliere[1][j]==1 && tavoliere[2][j+1]==1 && tavoliere[3][j+2]==1 && tavoliere[4][j+3]==1)
              			vincita = true;
          		 	else if (tavoliere[2][j]==1 && tavoliere[3][j+1]==1 && tavoliere[4][j+2]==1 && tavoliere[5][j+3]==1)
              			vincita = true;
                }     
   
              //trova 4 diagonali sinistre
                for (int j=6;j>2;j--){		
            		 if (tavoliere[0][j]==1 && tavoliere[1][j-1]==1 && tavoliere[2][j-2]==1 && tavoliere[3][j-3]==1)
            			 vincita = true;
            		 else if (tavoliere[1][j]==1 && tavoliere[2][j-1]==1 && tavoliere[3][j-2]==1 && tavoliere[4][j-3]==1)
            			 vincita = true;
            		 else if (tavoliere[2][j]==1 && tavoliere[3][j-1]==1 && tavoliere[4][j-2]==1 && tavoliere[5][j-3]==1)
            			 vincita = true;
                  }                  
                
      			return vincita; 
            }
	    
            public boolean controlloVincitaPC()
            {               
                boolean vincita=false;
		    
              //trova 4 orizzontali
                for (int i=5;i>=0;i--)
                	for (int j=0;j<4;j++){
                		if (tavoliere[i][j]==2 && tavoliere[i][j+1]==2 && tavoliere[i][j+2]==2 && tavoliere[i][j+3]==2)
                			vincita = true;
                	}
			
              //trova 4 verticali
                for (int i=0;i<3;i++)
                      for (int j=0;j<7;j++){		
                		 if (tavoliere[i][j]==2 && tavoliere[i+1][j]==2 && tavoliere[i+2][j]==2 && tavoliere[i+3][j]==2)
                			 vincita = true;
                      }
		      
              //trova 4 diagonali destre
                for (int j=0;j<4;j++){		
          		 	if (tavoliere[0][j]==2 && tavoliere[1][j+1]==2 && tavoliere[2][j+2]==2 && tavoliere[3][j+3]==2)
          		 		vincita = true;
          		 	else if (tavoliere[1][j]==2 && tavoliere[2][j+1]==2 && tavoliere[3][j+2]==2 && tavoliere[4][j+3]==2)
              			vincita = true;
          		 	else if (tavoliere[2][j]==2 && tavoliere[3][j+1]==2 && tavoliere[4][j+2]==2 && tavoliere[5][j+3]==2)
              			vincita = true;
                }     
   
              //trova 4 diagonali sinistre
                for (int j=6;j>2;j--){		
            		 if (tavoliere[0][j]==2 && tavoliere[1][j-1]==2 && tavoliere[2][j-2]==2 && tavoliere[3][j-3]==2)
            			 vincita = true;
            		 else if (tavoliere[1][j]==2 && tavoliere[2][j-1]==2 && tavoliere[3][j-2]==2 && tavoliere[4][j-3]==2)
            			 vincita = true;
            		 else if (tavoliere[2][j]==2 && tavoliere[3][j-1]==2 && tavoliere[4][j-2]==2 && tavoliere[5][j-3]==2)
            			 vincita = true;
                  }                  
                
      			return vincita; 
            }
            
            public int IA(){ 
        		 for (int i=2;i>=0;i--)		//attacco verticale
                   	for (int j=0;j<7;j++)
                   		if (tavoliere[i][j]==0 && tavoliere[i+1][j]==2 && tavoliere[i+2][j]==2 && tavoliere[i+3][j]==2)
                   			return (j+1);
        		 
            		for (int i=5;i>=0;i--)	//attacco orizzontale
                     	for (int j=0;j<4;j++){
                     		if (tavoliere[i][j]==2 && tavoliere[i][j+1]==2 && tavoliere[i][j+2]==2 && tavoliere[i][j+3]==0)
                     			return (j+4);                    			
                     		if (tavoliere[i][j]==2 && tavoliere[i][j+1]==2 && tavoliere[i][j+2]==0 && tavoliere[i][j+3]==2)
                     			return (j+3);
                     		if (tavoliere[i][j]==2 && tavoliere[i][j+1]==0 && tavoliere[i][j+2]==2 && tavoliere[i][j+3]==2)
                     			return (j+2);
                     		if (tavoliere[i][j]==0 && tavoliere[i][j+1]==2 && tavoliere[i][j+2]==2 && tavoliere[i][j+3]==2)
                     			return (j+1);
            		}
            		
             		 for (int i=0; i<3;i++)			//attacco diagonale destra
             			 for (int j=0;j<4;j++){
 	               		 	if (tavoliere[i][j]==0 && tavoliere[i+1][j+1]==2 && tavoliere[i+2][j+2]==2 && tavoliere[i+3][j+3]==2 && tavoliere[i+1][j]!=0)
 	               		 		return (j+1);             		 		
 	               		 	if (tavoliere[i][j]==2 && tavoliere[i+1][j+1]==0 && tavoliere[i+2][j+2]==2 && tavoliere[i+3][j+3]==2 && tavoliere[i+2][j+1]!=0)
 	               		 		return (j+2);
 	               		 	if (tavoliere[i][j]==2 && tavoliere[i+1][j+1]==2 && tavoliere[i+2][j+2]==0 && tavoliere[i+3][j+3]==2 && tavoliere[i+3][j+2]!=0)
 	               		 		return (j+3);
 	               		 	if (tavoliere[i][j]==2 && tavoliere[i+1][j+1]==2 && tavoliere[i+2][j+2]==2 && tavoliere[i+3][j+3]==0)
 	               		 		return (j+4);
             			 }
             		 
                      for (int i=0; i<3;i++)			//attacco diagonale sinistra
                      	for (int j=6;j>2;j--){		
                      		if (tavoliere[i][j]==0 && tavoliere[i+1][j-1]==2 && tavoliere[i+2][j-2]==2 && tavoliere[i+3][j-3]==2 && tavoliere[i+1][j]!=0)
                      			return (j+1);           		 		
                      		if (tavoliere[i][j]==2 && tavoliere[i+1][j-1]==0 && tavoliere[i+2][j-2]==2 && tavoliere[i+3][j-3]==2 && tavoliere[i+2][j-1]!=0)
                      			return (j);
                      		if (tavoliere[i][j]==2 && tavoliere[i+1][j-1]==2 && tavoliere[i+2][j-2]==0 && tavoliere[i+3][j-3]==2 && tavoliere[i+3][j+2]!=0)
                      			return (j-1);
                      		if (tavoliere[i][j]==2 && tavoliere[i+1][j-1]==2 && tavoliere[i+2][j-2]==2 && tavoliere[i+3][j-3]==0)
                      			return (j-2);
                      	}
                      
             		 for (int i=2;i>=0;i--)		//difesa verticale
                      	for (int j=0;j<7;j++)
                      		if (tavoliere[i][j]==0 && tavoliere[i+1][j]==1 && tavoliere[i+2][j]==1 && tavoliere[i+3][j]==1)
                      			return (j+1);
            		
            		for (int i=5;i>=0;i--)		//difesa orizzontale
                    	for (int j=0;j<4;j++){
                    		if (tavoliere[i][j]==1 && tavoliere[i][j+1]==1 && tavoliere[i][j+2]==1 && tavoliere[i][j+3]==0)
                    			return (j+4);                    			
                    		if (tavoliere[i][j]==1 && tavoliere[i][j+1]==1 && tavoliere[i][j+2]==0 && tavoliere[i][j+3]==1)
                    			return (j+3);
                    		if (tavoliere[i][j]==1 && tavoliere[i][j+1]==0 && tavoliere[i][j+2]==1 && tavoliere[i][j+3]==1)
                    			return (j+2);
                    		if (tavoliere[i][j]==0 && tavoliere[i][j+1]==1 && tavoliere[i][j+2]==1 && tavoliere[i][j+3]==1)
                    			return (j+1);
                    		if (tavoliere[i][j]==0 && tavoliere[i][j+1]==1 && tavoliere[i][j+2]==1 && tavoliere[i][j+3]==0)
                    			return (j+1);       
                    	}
                    		

            		 for (int i=0; i<3;i++)			//difesa diagonale destra
            			 for (int j=0;j<4;j++){		
	               		 	if (tavoliere[i][j]==0 && tavoliere[i+1][j+1]==1 && tavoliere[i+2][j+2]==1 && tavoliere[i+3][j+3]==1 && tavoliere[i+1][j]!=0)
	               		 		return (j+1);            		 		
	               		 	if (tavoliere[i][j]==1 && tavoliere[i+1][j+1]==0 && tavoliere[i+2][j+2]==1 && tavoliere[i+3][j+3]==1 && tavoliere[i+2][j+1]!=0)
	               		 		return (j+2);
	               		 	if (tavoliere[i][j]==1 && tavoliere[i+1][j+1]==1 && tavoliere[i+2][j+2]==0 && tavoliere[i+3][j+3]==1 && tavoliere[i+3][j+2]!=0)
	               		 		return (j+3);
	               		 	if (tavoliere[i][j]==1 && tavoliere[i+1][j+1]==1 && tavoliere[i+2][j+2]==0 && tavoliere[i+3][j+3]==0)
	               		 		return (j+4);
	                     	}   
                   
                     for (int i=0; i<3;i++)			//difesa diagonale sinistra
                     	for (int j=6;j>2;j--){		
                     		if (tavoliere[i][j]==0 && tavoliere[i+1][j-1]==1 && tavoliere[i+2][j-2]==1 && tavoliere[i+3][j-3]==1 && tavoliere[i+1][j]!=0)
                     			return (j+1);           		 		
                     		if (tavoliere[i][j]==1 && tavoliere[i+1][j-1]==0 && tavoliere[i+2][j-2]==1 && tavoliere[i+3][j-3]==1 && tavoliere[i+2][j-1]!=0)

                     			return (j);
                     		if (tavoliere[i][j]==1 && tavoliere[i+1][j-1]==1 && tavoliere[i+2][j-2]==0 && tavoliere[i+3][j-3]==1 && tavoliere[i+3][j+2]!=0)

                     			return (j-1);
                     		if (tavoliere[i][j]==1 && tavoliere[i+1][j-1]==1 && tavoliere[i+2][j-2]==1 && tavoliere[i+3][j-3]==0)
                     			return (j-2);
                     	}	
                     
                     return (int)(7*Math.random()+1);			//in caso di nessuna mossa favorevole inserisce un pezzo casuale     			
            }

            //MAIN con JOptionPane
           /* public static void main (String [] args){
            	Forza4 gioco = new Forza4();
            	JOptionPane.showMessageDialog(null, "Benvenuto a jForza4!");
            	JOptionPane.showMessageDialog(null, "Al momento nel tavoliere c'è: "+'\n'+gioco.getTavoliere());
            	
            	boolean vincita = false;
            	
            	gioco: while (vincita==false){
            	String x = JOptionPane.showInputDialog("Inserisci la colonna dove vuoi mettere il tuo pezzo "+'\n'+"(il quale sarà indicato col numero 1, mentre quello "+'\n'+"dell'avversario col numero 2)");
            	int input = Integer.parseInt(x);
            	if (input<1 || input>7){
            		JOptionPane.showMessageDialog(null, "Errore: devi inserire un numero da 1 a 7");
            		x = JOptionPane.showInputDialog("Inserisci la colonna dove vuoi mettere il tuo pezzo "+'\n'+"(il quale sarà indicato col numero 1, mentre quello "+'\n'+"dell'avversario col numero 2)");
            		input = Integer.parseInt(x);
            		gioco.inserisciPezzoRosso(input);
            	}
            	else
            		gioco.inserisciPezzoRosso(input);
            	 	
            	JOptionPane.showMessageDialog(null, "Al momento nel tavoliere c'è: "+'\n'+gioco.getTavoliere()); 
            	
            	if (gioco.controlloVincita()==true){
            		JOptionPane.showMessageDialog(null, "Complimenti, hai vinto! :D");
            		vincita=true;
            		break gioco;
            		}
            	
            	JOptionPane.showMessageDialog(null, "L'avversario fa la sua mossa...");
            	
            	//IA
            	boolean mossaPC = false;
            	loop: while (mossaPC == false){
            		
                    for (int i=5;i>=0;i--)		//difesa orizzontale
                    	for (int j=0;j<4;j++){
                    		if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i, j+1)==1 && gioco.controllaPezzo(i, j+2)==1 && gioco.controllaPezzo(i, j+3)==0){
                    			gioco.inserisciPezzoVerde(j+4);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==0 && gioco.controllaPezzo(i, j+1)==1 && gioco.controllaPezzo(i, j+2)==1 && gioco.controllaPezzo(i, j+3)==1){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i, j+1)==0 && gioco.controllaPezzo(i, j+2)==1 && gioco.controllaPezzo(i, j+3)==1){
                    			gioco.inserisciPezzoVerde(j+2);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i, j+1)==1 && gioco.controllaPezzo(i, j+2)==0 && gioco.controllaPezzo(i, j+3)==1){
                    			gioco.inserisciPezzoVerde(j+3);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i, j+1)==1 && gioco.controllaPezzo(i, j+2)==1 && gioco.controllaPezzo(i, j+3)==0){
                    			gioco.inserisciPezzoVerde(j+4);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==0 && gioco.controllaPezzo(i, j+1)==1 && gioco.controllaPezzo(i, j+2)==1 && gioco.controllaPezzo(i, j+3)==0){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    	}        
                    
                    for (int i=2;i>=0;i--)		//difesa verticale
                    	for (int j=0;j<7;j++){
                    		if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i+1, j)==1 && gioco.controllaPezzo(i+2, j)==1 && gioco.controllaPezzo(i+3, j)==0){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==0 && gioco.controllaPezzo(i+1, j)==1 && gioco.controllaPezzo(i+2, j)==1 && gioco.controllaPezzo(i+3, j)==1){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i+1, j)==0 && gioco.controllaPezzo(i+2, j)==1 && gioco.controllaPezzo(i+3, j)==1){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i+1, j)==1 && gioco.controllaPezzo(i+2, j)==0 && gioco.controllaPezzo(i+3, j)==1){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==1 && gioco.controllaPezzo(i+1, j)==1 && gioco.controllaPezzo(i+2, j)==1 && gioco.controllaPezzo(i+3, j)==0){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    	}                    
                
                    for (int i=0; i<3;i++)			//difesa diagonale destra
                    	for (int j=0;j<4;j++){		
              		 	if (gioco.controllaPezzo(i,j)==0 && gioco.controllaPezzo(i+1,j+1)==1 && gioco.controllaPezzo(i+2,j+2)==1 && gioco.controllaPezzo(i+3,j+3)==1 && gioco.controllaPezzo(i+1,j)!=0){
              		 		gioco.inserisciPezzoVerde(j+1);
              		 		mossaPC=true;
              		 		break loop;
              		 		}              		 		
          		 	if (gioco.controllaPezzo(i,j)==1 && gioco.controllaPezzo(i+1,j+1)==0 && gioco.controllaPezzo(i+2,j+2)==1 && gioco.controllaPezzo(i+3,j+3)==1 && gioco.controllaPezzo(i+2,j+1)!=0){
          		 		gioco.inserisciPezzoVerde(j+2);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==1 && gioco.controllaPezzo(i+1,j+1)==1 && gioco.controllaPezzo(i+2,j+2)==0 && gioco.controllaPezzo(i+3,j+3)==1 && gioco.controllaPezzo(i+3,j+2)!=0){
          		 		gioco.inserisciPezzoVerde(j+3);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==1 && gioco.controllaPezzo(i+1,j+1)==1 && gioco.controllaPezzo(i+2,j+2)==1 && gioco.controllaPezzo(i+3,j+3)==0){
          		 		gioco.inserisciPezzoVerde(j+4);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
            		}   
                  
                    for (int i=0; i<3;i++)			//difesa diagonale sinistra
                    	for (int j=6;j>2;j--){		
              		 	if (gioco.controllaPezzo(i,j)==0 && gioco.controllaPezzo(i+1,j-1)==1 && gioco.controllaPezzo(i+2,j-2)==1 && gioco.controllaPezzo(i+3,j-3)==1 && gioco.controllaPezzo(i+1,j)!=0){
              		 		gioco.inserisciPezzoVerde(j+1);
              		 		mossaPC=true;
              		 		break loop;
              		 		}              		 		
          		 	if (gioco.controllaPezzo(i,j)==1 && gioco.controllaPezzo(i+1,j-1)==0 && gioco.controllaPezzo(i+2,j-2)==1 && gioco.controllaPezzo(i+3,j-3)==1 && gioco.controllaPezzo(i+2,j-1)!=0){
          		 		gioco.inserisciPezzoVerde(j);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==1 && gioco.controllaPezzo(i+1,j-1)==1 && gioco.controllaPezzo(i+2,j-2)==0 && gioco.controllaPezzo(i+3,j-3)==1 && gioco.controllaPezzo(i+3,j+2)!=0){
          		 		gioco.inserisciPezzoVerde(j-1);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==1 && gioco.controllaPezzo(i+1,j-1)==1 && gioco.controllaPezzo(i+2,j-2)==1 && gioco.controllaPezzo(i+3,j-3)==0){
          		 		gioco.inserisciPezzoVerde(j-2);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
            		}                       
                    
                    for (int i=5;i>=0;i--)		//attacco orizzontale
                    	for (int j=0;j<4;j++){
                    		if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i, j+1)==2 && gioco.controllaPezzo(i, j+2)==2 && gioco.controllaPezzo(i, j+3)==0){
                    			gioco.inserisciPezzoVerde(j+4);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==0 && gioco.controllaPezzo(i, j+1)==2 && gioco.controllaPezzo(i, j+2)==2 && gioco.controllaPezzo(i, j+3)==2){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i, j+1)==0 && gioco.controllaPezzo(i, j+2)==2 && gioco.controllaPezzo(i, j+3)==2){
                    			gioco.inserisciPezzoVerde(j+2);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i, j+1)==2 && gioco.controllaPezzo(i, j+2)==0 && gioco.controllaPezzo(i, j+3)==2){
                    			gioco.inserisciPezzoVerde(j+3);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i, j+1)==2 && gioco.controllaPezzo(i, j+2)==2 && gioco.controllaPezzo(i, j+3)==0){
                    			gioco.inserisciPezzoVerde(j+4);
                    			mossaPC=true;
                    			break loop;
                    		}
                    	}                     
                   
                    for (int i=2;i>=0;i--)		//attacco verticale
                    	for (int j=0;j<7;j++){
                    		if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i+1, j)==2 && gioco.controllaPezzo(i+2, j)==2 && gioco.controllaPezzo(i+3, j)==0){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==0 && gioco.controllaPezzo(i+1, j)==2 && gioco.controllaPezzo(i+2, j)==2 && gioco.controllaPezzo(i+3, j)==2){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i+1, j)==0 && gioco.controllaPezzo(i+2, j)==2 && gioco.controllaPezzo(i+3, j)==2){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i+1, j)==2 && gioco.controllaPezzo(i+2, j)==0 && gioco.controllaPezzo(i+3, j)==2){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    		else if (gioco.controllaPezzo(i, j)==2 && gioco.controllaPezzo(i+1, j)==2 && gioco.controllaPezzo(i+2, j)==2 && gioco.controllaPezzo(i+3, j)==0){
                    			gioco.inserisciPezzoVerde(j+1);
                    			mossaPC=true;
                    			break loop;
                    		}
                    	}  
                    
                    for (int i=0; i<3;i++)			//attacco diagonale destra
                    	for (int j=0;j<4;j++){		
              		 	if (gioco.controllaPezzo(i,j)==0 && gioco.controllaPezzo(i+1,j+1)==2 && gioco.controllaPezzo(i+2,j+2)==2 && gioco.controllaPezzo(i+3,j+3)==2 && gioco.controllaPezzo(i+1,j)!=0){
              		 		gioco.inserisciPezzoVerde(j+1);
              		 		mossaPC=true;
              		 		break loop;
              		 		}              		 		
          		 	if (gioco.controllaPezzo(i,j)==2 && gioco.controllaPezzo(i+1,j+1)==0 && gioco.controllaPezzo(i+2,j+2)==2 && gioco.controllaPezzo(i+3,j+3)==2 && gioco.controllaPezzo(i+2,j+1)!=0){
          		 		gioco.inserisciPezzoVerde(j+2);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==2 && gioco.controllaPezzo(i+1,j+1)==2 && gioco.controllaPezzo(i+2,j+2)==0 && gioco.controllaPezzo(i+3,j+3)==2 && gioco.controllaPezzo(i+3,j+2)!=0){
          		 		gioco.inserisciPezzoVerde(j+3);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==2 && gioco.controllaPezzo(i+1,j+1)==2 && gioco.controllaPezzo(i+2,j+2)==2 && gioco.controllaPezzo(i+3,j+3)==0){
          		 		gioco.inserisciPezzoVerde(j+4);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
            		}   
                  
                    for (int i=0; i<3;i++)			//attacco diagonale sinistra
                    	for (int j=6;j>2;j--){		
              		 	if (gioco.controllaPezzo(i,j)==0 && gioco.controllaPezzo(i+1,j-1)==2 && gioco.controllaPezzo(i+2,j-2)==2 && gioco.controllaPezzo(i+3,j-3)==2 && gioco.controllaPezzo(i+1,j)!=0){
              		 		gioco.inserisciPezzoVerde(j+1);
              		 		mossaPC=true;
              		 		break loop;
              		 		}              		 		
          		 	if (gioco.controllaPezzo(i,j)==2 && gioco.controllaPezzo(i+1,j-1)==0 && gioco.controllaPezzo(i+2,j-2)==2 && gioco.controllaPezzo(i+3,j-3)==2 && gioco.controllaPezzo(i+2,j-1)!=0){
          		 		gioco.inserisciPezzoVerde(j);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==2 && gioco.controllaPezzo(i+1,j-1)==2 && gioco.controllaPezzo(i+2,j-2)==0 && gioco.controllaPezzo(i+3,j-3)==2 && gioco.controllaPezzo(i+3,j+2)!=0){
          		 		gioco.inserisciPezzoVerde(j-1);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
                    if (gioco.controllaPezzo(i,j)==2 && gioco.controllaPezzo(i+1,j-1)==2 && gioco.controllaPezzo(i+2,j-2)==2 && gioco.controllaPezzo(i+3,j-3)==0){
          		 		gioco.inserisciPezzoVerde(j-2);
          		 		mossaPC=true;
          		 		break loop;
          		 		}
            		}  
                    
                    if (mossaPC==false){	// mossa iniziale
                    	gioco.inserisciPezzoVerde((int)(7*Math.random()+1));
                    	mossaPC=true;
                    	break loop;	
                    }
            	}
            	
            	JOptionPane.showMessageDialog(null, "Al momento nel tavoliere c'è: "+'\n'+gioco.getTavoliere()); 

            	if (gioco.controlloVincitaPC()==true){
            		JOptionPane.showMessageDialog(null, "Hai perso! Ritenta :(");
            		vincita=true;
            		}
            	}
            }*/
}