package id.aulab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.aulab.repository.TriangleRepoImp;

@Component("triangleServices")
public class CanATriangleImp implements CanATriangle{

    @Autowired
    private TriangleRepoImp triangleRepoImp;

    public CanATriangleImp(TriangleRepoImp triangleRepoImp) {
        this.triangleRepoImp = triangleRepoImp;
    }

    @Override
    public void roll() {
        if(this.triangleRepoImp.getTriangle() == null)
            System.out.println("You're in the wrong ueclihood.");
    };

    @Override
    public void sting() {
        if(this.triangleRepoImp.getTriangle() == null)
            System.out.println("The problem is the 2D, but it should.");
    }

    @Override
    public void love() {
        if(this.triangleRepoImp.getTriangle() == null)
            System.out.println("If you give it permission, yes.");
    }

    public TriangleRepoImp getCanTriangle() {
        return triangleRepoImp;
    }

    public void setCanTriangle(TriangleRepoImp triangleRepoImp) {
        this.triangleRepoImp = triangleRepoImp;
    };
}
