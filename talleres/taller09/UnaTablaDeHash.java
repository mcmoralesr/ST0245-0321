
//Una tabla de hash donde la llave es un String y el valor un int.
public class UnaTablaDeHash
{
   // Ojo, esta tabla definida así no permite manejar las colisiones
   private int[] tabla;

   public UnaTablaDeHash(){
      tabla = new int[10];
   }

   // Ojo, esta función hash es muy ingenua
   private int funcionHash(String k){
       return ((int) k.charAt(0)) % 10;
   }

   // Ojo con las colisiones
   public int get(String k){
      return tabla[funcionHash(k)];
    }


   // Ojo con las colisiones
   public void put(String k, int v){
      int location = funcionHash(k);
      if(tabla[location]== 0){
         tabla[location] = v;
      } else {
         for(int i = 0; i < tabla.length; i ++){
            if(tabla[i]== 0){
               tabla[i]= v;
               break;
            }
         }
      }

   }
}