package id.aulab.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.aulab.model.Triangle;

@Component("TriangleRepository")
public class TriangleRepoImp implements TriangleRepository{

    @Autowired
    private Triangle triangle;

    @Override
    public Triangle getTriangle(){
        return this.triangle;
    };

    @Override
    public void setTriangle(Triangle triangle){
        this.triangle = triangle;
    }

}
