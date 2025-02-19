package ProblemaArray;
import java.util.Arrays;

public class EjercicioArrays {

    static class Clase {

        private int numAlumnos;
        private int[] notas;
        private int[] listaClase;
        private Integer[][] MinMax;
        private int[] practicas;
        private float[] calFinal;
        private float[] estadistica;
        private int[] aproSus;

        public Clase(int numAlumnos) {
        	
            this.numAlumnos = numAlumnos;
            this.notas = new int[numAlumnos];
            this.listaClase = new int[numAlumnos];
            this.practicas = new int[numAlumnos];
            this.calFinal = new float[numAlumnos];
            this.estadistica = new float[10];
            this.MinMax = new Integer[2][2];
            this.aproSus = new int[2];

            // Genera una lista automáticamente al crear el objeto
            for (int i = 0; i < numAlumnos; i++) {
                listaClase[i] = i + 1;
            }
        }

        public void generarNotas() {
        	
            for (int i = 0; i < this.numAlumnos; i++) {
                this.notas[i] = (int) (Math.random() * 11);
                this.practicas[i] = (int) (Math.random() * 11);
            }
        }

        public float[] MediaCalificaciones() {
        	
            for (int i = 0; i < notas.length; i++) {
                calFinal[i] = (((float) notas[i] + (float) practicas[i]) / 2);
            }
            return calFinal;
        }

        public void calcularEstadistica() {
        	
            for (int i = 0; i < 10; i++) {
                float count = 0;
                for (int j = 0; j < calFinal.length; j++) {
                    if ((i < calFinal[j]) && ((i + 1) >= calFinal[j])) {
                        count += 1;
                    }
                }
                this.estadistica[i] = count / numAlumnos;
                double sol = (Math.round(this.estadistica[i] * 10000.0)) / 100.0;
                System.out.println("Estadística nota tramo <=" + (i + 1) + " = " + sol + "%");
            }
        }

        public void FindMinMax() {
        	
            MinMax = new Integer[][]{{10, 0}, {0, 0}};

            for (int i = 0; i < notas.length; i++) {
                if (notas[i] < MinMax[0][0]) {
                    this.MinMax[0][0] = notas[i];
                    this.MinMax[0][1] = i;
                }
                if (notas[i] > MinMax[1][0]) {
                    this.MinMax[1][0] = notas[i];
                    this.MinMax[1][1] = i;
                }
            }
        }

        public void AprobadosSuspensos() {
        	
            for (int i = 0; i < numAlumnos; i++) {
                if (notas[i] < 5) {
                    aproSus[1]++;
                } else {
                    aproSus[0]++;
                }
            }

            System.out.println("Relación de aprobados por nº de lista: " + aproSus[0]);
            System.out.println("Relación de suspensos por nº de lista: " + aproSus[1]);
        }

        public void ResumenAproSus() {
        	
            int[][] AproSusList = new int[numAlumnos][numAlumnos];

            for (int i = 0; i < notas.length; i++) {
                if (notas[i] < 5) {
                    AproSusList[1][i] = notas[i];
                } else {
                    AproSusList[0][i] = notas[i];
                }
            }
            
            System.out.println("Resumen de aprobados por nº de lista: " + Arrays.toString(AproSusList[1]));
            System.out.println("Resumen de suspensos por nº de lista: " + Arrays.toString(AproSusList[0]));
        }

        public void MostrarInfo() {
        	
            System.out.println("Mínimo es: " + MinMax[0][0]);
            System.out.println("Máximo es: " + MinMax[1][0]);
            System.out.println("Índice del mínimo es: " + MinMax[0][1]);
            System.out.println("Índice del máximo es: " + MinMax[1][1]);
            System.out.println("Lista de clase: " + Arrays.toString(listaClase));
            System.out.println("Array de Notas: " + Arrays.toString(notas));
            System.out.println("Prácticas: " + Arrays.toString(practicas));
            System.out.println("Calificaciones: " + Arrays.toString(calFinal));
        }
        
        public void insertarNuevaNota() {

            int[] nuevasNotas = new int[40];
            
            for (int j = 0; j < 31; j++) {
                nuevasNotas[j] = (int) (Math.random() * 11);
            }

            System.out.println("Nota antigua alumno nº4: " + nuevasNotas[3]);
            
            nuevasNotas[3] = 6;

            System.out.println("Nota nueva alumno nº4: " + nuevasNotas[3]);

            this.notas = nuevasNotas;
        }

        
    }

    public static void main(String[] args) {
    	
        int numAlumnos = 40;

        // Crea un objeto clase1 y otro llamado clase
        Clase clase1 = new Clase(numAlumnos);

        // Generar notas aleatorias
        clase1.generarNotas();

        // Calcular la media de las calificaciones
        clase1.MediaCalificaciones();

        // Encontrar la nota mínima y máxima junto con su índice
        clase1.FindMinMax();

        // Mostrar la información general
        clase1.MostrarInfo();

        // Calcular y mostrar la estadística de notas
        clase1.calcularEstadistica();

        // Determinar aprobados y suspensos
        clase1.AprobadosSuspensos();

        // Mostrar resumen de aprobados y suspensos
        clase1.ResumenAproSus();
        
        /*6. Suponer un vector de Calificaciones de tamaño 40 
        (máximo de alumnos por clase), pero que solo almacena las
        notas de 31 alumnos. Realizar un programa que permita insertar en
        la posición 4 del vector la calificación de un nuevo 
        alumno en clase al que supuestamente le corresponde como nota un 6.*/
        
        clase1.insertarNuevaNota();
    }
} 