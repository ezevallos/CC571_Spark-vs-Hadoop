package countsales;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class SalesMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);

	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
                IntWritable numero = new IntWritable(0);
                //Text etiquetaM = new Text("Mayor Venta: ");
                //Text etiquetam = new Text("Menor Venta: ");
                //Text etiqueta = new Text("Cantidad Mayor Igual a M: ");
		String valueString = value.toString();
		String[] SingleCountryData = valueString.split(",");
                //Contador de Paises
		//output.collect(new Text(SingleCountryData[7]), one);
                //Contador de Tarjetas de Credito
		//output.collect(new Text(SingleCountryData[3]), one);
                //Suma Total de Venta
                //if(!("Price").equals(SingleCountryData[2]) && !("\"13").equals(SingleCountryData[2]))
                //    numero = new IntWritable(Integer.parseInt(SingleCountryData[2]));
                //else numero = new IntWritable(0);
                //output.collect(etiqueta, numero);
                //Contador de Ventas por Tipo de Producto
                //output.collect(new Text(SingleCountryData[1]), numero);
                //if(!("Price").equals(SingleCountryData[2])){
                //    if(("\"13").equals(SingleCountryData[2]))
                //        numero = new IntWritable(13000);
                //    else numero = new IntWritable(Integer.parseInt(SingleCountryData[2]));
                //}
                //else numero = new IntWritable(0);
                //if(("Product3 ").equals(SingleCountryData[1]))
                //    etiqueta = new Text("Product3");
                //else etiqueta = new Text(SingleCountryData[1]);
                //output.collect(etiqueta, numero);
                //Contador de ventas Mayores Iguales a M por Pais
                //if(!("Price").equals(SingleCountryData[2]))
                //    if(("\"13").equals(SingleCountryData[2]))
                //        numero = new IntWritable(13000);
                //    else numero = new IntWritable(Integer.parseInt(SingleCountryData[2]));
                //    if(numero.compareTo(new IntWritable(3000)) >= 0)
                //        output.collect(new Text(SingleCountryData[7]), numero);
                //else numero = new IntWritable(0);
                //Comparador de Ventas - La codificación es en SalesCountryReducer
                /*if(!("Price").equals(SingleCountryData[2])){
                    if(("\"13").equals(SingleCountryData[2]))
                        numero = new IntWritable(13000);
                    else numero = new IntWritable(Integer.parseInt(SingleCountryData[2]));
                    output.collect(etiquetaM, numero);
                }*/
                // Comparador de Ventas por Tipo de Pago
                if(!("Price").equals(SingleCountryData[2])){
                    if(("\"13").equals(SingleCountryData[2]))
                        numero = new IntWritable(13000);
                    else numero = new IntWritable(Integer.parseInt(SingleCountryData[2]));
                    output.collect(new Text(SingleCountryData[3]), numero);
                }
	}
}
