package bd;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import modelo.verbo;
import org.bson.Document;

public class ConexionMongo {
     MongoClient mongo;
    MongoDatabase db;
    //METODO PARA CREAR LA BASE DE DATOS
  
    public void CrearConexion() {
        MongoClientURI uri = new MongoClientURI(
        "mongodb+srv://joseenrique:joseenrique@cluster0.q7i79.mongodb.net/alvali?retryWrites=true&w=majority");
        System.out.println("Conexion base de dato con exito");
        mongo = new MongoClient(uri);
        db = mongo.getDatabase("LearnVerbs");
    }
    public  void desconectar() {
      mongo.close();
        System.out.println("Base datos desconectada");
        
  }
    
     public void insertar(verbo u) {
        CrearConexion();
        MongoCollection<Document> collection = db.getCollection("verbos");
        Document doc = new Document()
                .append("infinitive", u.getInfinitive())
                .append("simplePast", u.getSimplePast())
                .append("pastParticiple", u.getPastParticiple())
                .append("spanish", u.getSpanish());
        collection.insertOne(doc);
        System.out.println("Documento Insertado correctamente");
       desconectar();
    }
     
       public List<verbo> mostrar() {
        CrearConexion();
        List<verbo> listaVerbos = new ArrayList<verbo>();
        FindIterable<Document> mydata = db.getCollection("verbos").find();
        System.out.println("Mostrando usurios");
      
        MongoCursor<Document> iterator = mydata.iterator();
        while (iterator.hasNext()) {
            verbo u = new verbo();
            Document doc = iterator.next();
            u.setId(doc.getObjectId("_id").toString());
            u.setInfinitive(doc.getString("infinitive"));
            u.setSimplePast(doc.getString("simplePast"));
            u.setPastParticiple(doc.getString("pastParticiple"));
            u.setSpanish(doc.getString("spanish"));
            listaVerbos.add(u);
        }
        
        desconectar();
        return listaVerbos;
       
    }  
}
