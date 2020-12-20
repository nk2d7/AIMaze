import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList; 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~





public class Maze2 {
	
	public static void main(String[] args) {

	//mazeImplementation~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		String [][] maze = new String[6][5];
		
		//white Squares 
		maze[1][1]="J";
		maze[1][2]="H";
		maze[1][3]="F";
		maze[2][1]="K";
		maze[2][3]="E";
		maze[3][1]="L";
		maze[3][3]="D";
		maze[4][1]="A";
		maze[4][2]="B";
		maze[4][3]="C"; 
		
		maze[4][4]="G";
		String finalState=maze[4][4];
		
		maze[5][1]="I";
		String initialState= maze[5][1];
		
        //black Squares
		maze[0][0]="black";
		maze[0][1]="black";
		maze[0][2]="black";
		maze[0][3]="black";
		maze[0][4]="black";
		
		maze[1][0]="black";
		maze[1][4]="black";
		
		maze[2][0]="black";
		maze[2][2]="black";
		maze[2][4]="black";
		
		maze[3][0]="black";
		maze[3][2]="black";
		maze[3][4]="black";
		
		maze[4][0]="black";
		
		maze[5][0]="black";
		maze[5][2]="black";
		maze[5][3]="black";
		maze[5][4]="black";
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			
			ArrayList<String> searchSet= new ArrayList<String>(); 
			ArrayList<String> children=new ArrayList<String>();  
			ArrayList<String> closedSet = new ArrayList<String>(); 
			
		
			int limit=100000000;// orio
			String finalSolution="Not found!";
			
			String microscope;
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			searchSet.add(initialState);	
			int x=5; 
			int y=1;
			System.out.print("Initial State : ");
			System.out.print(initialState);
			System.out.println(" ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
			while(searchSet.isEmpty() != true ) {
			
			    /////////////////////
				//print searchSet
				System.out.print("Search Set : [ ");
				for( int i=0;i<searchSet.size();i++) {
					
					System.out.print(searchSet.get(i));
					
					if(i== (searchSet.size() - 1)) {
						
						System.out.print(" ] ");
						System.out.println(" ");
						
					}else {

						System.out.print(" , ");
					
					}
				}
				
	            ////////////////////////////////////////
                System.out.print("Closed Set : [ ");
				 
				 if(closedSet.isEmpty()) {
					
					System.out.print(" ] ");
					System.out.println(" ");
					
				 }else { 
				 
				   for( int i=0;i< closedSet.size();i++) {
					 
					
                    System.out.print(closedSet.get(i));
					
					if(i== (closedSet.size() - 1)) {
						
						System.out.print(" ] ");
						System.out.println(" ");
						
					}else {

						System.out.print(" , ");
					
					}
				  }	
				} 
				
				
				//////////////////////////////////////////////////
				
					
				System.out.print("Current Path in microscope:");
				System.out.print(searchSet.get(0)); // whole path 
				System.out.println(" ");
			
				
				microscope=searchSet.get(0).substring(searchSet.get(0).length()-1 );//inserting last state of the path into the microscope 
				
			
				
				System.out.print("Current State in microscope:");
				System.out.print(microscope); 
				System.out.println(" ");
				
				
				
				
				for(int i=0;i<6;i++) {
					
					for(int j=0;j<5;j++) { 
					   
						
						if (microscope.equals(maze[i][j]) ) {
							
							x=i;
							y=j;
							
						
							break;
						}
						
					}
				}

				
	            //---------------------------------------------------------------------------------------
	              
				if (microscope.equals(finalState) ) {
					
					System.out.println(" ");
					System.out.print("! Solution Found ! : ");
					System.out.print(searchSet.get(0));
					finalSolution=searchSet.get(0);
					System.out.println(" ");
					System.out.println(" ");
					limit=searchSet.get(0).length()-1;
					System.out.print("Path Length : ");
					System.out.print(limit);
					System.out.print("  --> New limit!!(best solution/path we have so far) ");
					System.out.println(" ");
					System.out.println(" ");
					
					
				}else if((searchSet.get(0).length()-1)> limit){
				
					
					System.out.print("Path length is too long in comparison to the current limit(path length of the best solution we have so far)."
							+ "As a result we have to <<cut>>(not examine) this certain path since it will not provide a better solution . ");
					System.out.println(" ");
					
					
				}else if(!(closedSet.contains(microscope)) ) {
					
					//find children of the <<microscope>> state 
					 if((x-1)>=0){			
							if((maze[x-1][y] != "black")) {
								
								String newState= maze[x-1][y];
								String childPath=searchSet.get(0) + newState;
								children.add(childPath);
							    
								
								   
							}
	                     }
						
						 if(((y-1)>=0)){
							 	if(maze[x][y-1] != "black") {
							 		String newState=maze[x][y-1] ;
									String childPath=searchSet.get(0) + newState;
									children.add(childPath);
								   
								}
						}
						

					
						 if(((x+1)<=5)){
							if(maze[x+1][y]!= "black") {
								String newState= maze[x+1][y];
								String childPath=searchSet.get(0) + newState;
								children.add(childPath);
							    
							}
					    }
						 
					
					    if(((y+1)<=4)){
						  if(maze[x][y+1]!= "black") {
							  String newState=maze[x][y+1];
								String childPath=searchSet.get(0) + newState;
								children.add(childPath);
							   
							
						 }
					   }
					 
					
	               
					
					//////////////////////////////////////////////
					System.out.print("Children States : [ ");
					
					for( int i=0;i< children.size();i++) {
						 
						
                        System.out.print(children.get(i));
						
						if(i== (children.size() - 1)) {
							
							System.out.print(" ] ");
							System.out.println(" ");
							
						}else {

							System.out.print(" , ");
						
						}
						
						searchSet.add(children.get(i));
						
					 }
					
					
					
                     children.clear();
					
					
				}
				///////////////////////////////////////////////////////
			
				 if (!(closedSet.contains(microscope))){
					 
					closedSet.add(microscope);  
					
				    
					
				}
					
				////////////////////////////////////////////////////	
					
				
			  
			    searchSet.remove(0);  	
			     
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
					
			
				
			}
			
			System.out.println("  "); 
			System.out.print("!Final Solution! : ");
			System.out.print(finalSolution);
			System.out.println("  ");
			System.out.println("  ");
			System.out.print("Path length:");
			System.out.print(finalSolution.length()-1);
			System.out.println("  "); 
			System.out.println("  "); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   }
}
