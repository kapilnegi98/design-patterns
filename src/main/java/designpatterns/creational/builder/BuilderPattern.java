package designpatterns.creational.builder;


/**
 * 1. Creational Design Pattern - Helps in creating complex objects
 * 2. Objects created by builder pattern are immutable
 * 3. Less need to expose setters
 * 4. Without buider pattern we have to create all combination of constructor
 * 5. Creating a all args constructor and passing null values for optional fields leads to bugs in code.
 * Suppose we have to add a new field in the code then we have to create new constructor or change all the calls to
 * the constructor
 * 6. StringBuilder also use builder pattern
 */

/**
 * @author Kapil Negi
 * URL Builder
 */
class URLBuilder {

    /*Inner class should be static because if is not static we will not be able to creare*/
     class Builder{
        private String protocol;
        private String hostname;
        private String port;
        private String queryParam;
        Builder protocol(String protocol){
            this.protocol = protocol;
            return this;
        }
        Builder hostname(String hostname){
            this.hostname = hostname;
            return this;
        }
        Builder port(String port){
            this.port = port;
            return this;
        }
        Builder queryParam(String queryParam){
            this.queryParam = queryParam;
            return this;
        }
        URLBuilder build(){
            return new URLBuilder(this);
        }
    }

    private String protocol;
    private String hostname;
    private String port;
    private String queryParam;
    URLBuilder(){

    }
     URLBuilder(Builder builder){
        this.protocol = builder.protocol;
        this.hostname = builder.hostname;
        this.queryParam = builder.queryParam;
        this.port = builder.port;
    }
}
public class BuilderPattern{
    public static void main(String[] args) {
        URLBuilder u = new URLBuilder();
        URLBuilder.Builder b = u.new Builder().hostname("www").port("444");

    }
}
