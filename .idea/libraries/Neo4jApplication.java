package com.example.neo4j;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Neo4jApplication {

    public static void main(String[] args) throws FileNotFoundException {
        GraphDatabaseService graphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(ResourceUtils.getFile("classpath:dir"));
        Transaction transaction = graphDatabaseService.beginTx();
        Node person = graphDatabaseService.createNode(Label.label("person"));
        person.setProperty("name","huachao");

        Node person2 = graphDatabaseService.createNode(Label.label("person"));
        person2.setProperty("name","huating");

        Node dog = graphDatabaseService.createNode(Label.label("dog"));
        dog.setProperty("name","xiaohua");

        Node cat = graphDatabaseService.createNode(Label.label("cat"));
        cat.setProperty("name","miaomiao");

        dog.createRelationshipTo(cat,RelationshipType.withName("haoyou"));

        person.createRelationshipTo(dog,RelationshipType.withName("congwu"));

        person.createRelationshipTo(person2, RelationshipType.withName("兄妹"));


        Result execute = graphDatabaseService.execute("match (a)-[*..2]-(b:cat{name:'miaomiao'}) return a");
        execute.stream().forEach(a->{
            Node node= (Node) a.get("a");
            System.out.println(node.getLabels());
            System.out.println(node.getAllProperties());

        });
        transaction.success();
    }

}
