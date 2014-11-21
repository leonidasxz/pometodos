/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entrenador;

/**
 *
 * @author fcuevas
 */
public class ControladorRanking {
    
    private int rankingEntrenador1;
    private int rankingEntrenador2;
    public boolean rankingActualizado = false;
    
    public void actualizarRanking(Entrenador entrenador1, Entrenador entrenador2){
        /*
        Consideramos un ranking que parte desde 0
        victoria de ranking similar (ranking 1 - ranking 2 =< 15) da 10 puntos
        victoria de ranking notablemente mayor (ranking 1 - ranking 2 
        > 15 y =< 30) da 5 puntos 
        victoria de ranking extremadamente mayor (ranking 1 - ranking 2 > 30
        da 2 puntos
        Estos puntos se restan del perdedor
        
        En caso de que el entrenador con mayor ranking pierda, los puntajes son:
        10, 15, 20
        
        */
        rankingEntrenador1 = entrenador1.getRanking();
        rankingEntrenador2 = entrenador2.getRanking();
        
        if (entrenador1.esGanador){
            if (rankingEntrenador1 >= rankingEntrenador2){
                if (rankingEntrenador1 - rankingEntrenador2 <= 15){
                    rankingEntrenador1 =+ 10;
                    rankingEntrenador2 =- 10;
                }
                else if ((rankingEntrenador1 - rankingEntrenador2 > 15) || 
                        (rankingEntrenador1 - rankingEntrenador2 <= 30)){
                    rankingEntrenador1 =+ 5;
                    rankingEntrenador2 =- 5;
                }
                else{
                    rankingEntrenador1 =+ 2;
                    rankingEntrenador2 =- 2;
                }
            }
            else {
                if (rankingEntrenador2 - rankingEntrenador1 <= 15){
                    rankingEntrenador1 =+ 10;
                    rankingEntrenador2 =- 10;
                }
                else if ((rankingEntrenador2 - rankingEntrenador1 > 15) || 
                        (rankingEntrenador2 - rankingEntrenador1 <= 30)){
                    rankingEntrenador1 =+ 15;
                    rankingEntrenador2 =- 15;
                }
                else{
                    rankingEntrenador1 =+ 20;
                    rankingEntrenador2 =- 20;
                }                
            }           
        }
        else if(entrenador2.esGanador){
            if (rankingEntrenador1 >= rankingEntrenador2){
                if (rankingEntrenador1 - rankingEntrenador2 <= 15){
                    rankingEntrenador1 =+ 10;
                    rankingEntrenador2 =- 10;
                }
                else if ((rankingEntrenador1 - rankingEntrenador2 > 15) || 
                        (rankingEntrenador1 - rankingEntrenador2 <= 30)){
                    rankingEntrenador1 =+ 5;
                    rankingEntrenador2 =- 5;
                }
                else{
                    rankingEntrenador1 =+ 2;
                    rankingEntrenador2 =- 2;
                }
            }
            else {
                if (rankingEntrenador2 - rankingEntrenador1 <= 15){
                    rankingEntrenador1 =+ 10;
                    rankingEntrenador2 =- 10;
                }
                else if ((rankingEntrenador2 - rankingEntrenador1 > 15) || 
                        (rankingEntrenador2 - rankingEntrenador1 <= 30)){
                    rankingEntrenador1 =+ 15;
                    rankingEntrenador2 =- 15;
                }
                else{
                    rankingEntrenador1 =+ 20;
                    rankingEntrenador2 =- 20;
                }                
            }            
        }
        if (rankingEntrenador1 < 0){
            rankingEntrenador1 = 0;
        }
        if (rankingEntrenador2 < 0){
            rankingEntrenador2 = 0;
        }
        rankingActualizado = true;
    }    
}
