package com.daw.jsfproject;

import java.io.InputStream;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;

/**
 *
 * @author MIsabelCarde
 */
@Named
@ApplicationScoped
public class InfoBean implements Serializable {
    
    private TagCloudModel highLevel;
    private TagCloudModel mediumLevel;
    private TagCloudModel lowLevel;
    private TagCloudModel interests;
    private StreamedContent cvFile; 
     
    @PostConstruct
    public void init() {
        setHighLevel(new DefaultTagCloudModel());
        setMediumLevel(new DefaultTagCloudModel());
        setLowLevel(new DefaultTagCloudModel());
        configHighLevel();
        configMediumLevel();
        configLowLevel();
        
        setInterests(new DefaultTagCloudModel());
        configInterests();
        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/CV_MICS_(DAW).pdf");
        cvFile = new DefaultStreamedContent(stream, "application/pdf", "CV_MICS_(DAW).pdf");
    }
 
    private void configHighLevel(){
        highLevel.addTag(new DefaultTagCloudItem("Java", 5));
        highLevel.addTag(new DefaultTagCloudItem("HTML", 4));
        highLevel.addTag(new DefaultTagCloudItem("CSS", 3));
    }
    
    private void configMediumLevel(){
        mediumLevel.addTag(new DefaultTagCloudItem("Python", 5));
        mediumLevel.addTag(new DefaultTagCloudItem("JSF", 4));
        mediumLevel.addTag(new DefaultTagCloudItem("PrimeFaces", 4));
        mediumLevel.addTag(new DefaultTagCloudItem("JavaScript (+jQuery)", 4));
        mediumLevel.addTag(new DefaultTagCloudItem("MySQL", 4));
        mediumLevel.addTag(new DefaultTagCloudItem("REST", 4));
        mediumLevel.addTag(new DefaultTagCloudItem("Scrum", 4));
        mediumLevel.addTag(new DefaultTagCloudItem("Kanban", 4));
        mediumLevel.addTag(new DefaultTagCloudItem("Git", 3));
        mediumLevel.addTag(new DefaultTagCloudItem("BPMN", 3));
        mediumLevel.addTag(new DefaultTagCloudItem("UML", 3));
        mediumLevel.addTag(new DefaultTagCloudItem("System administration", 2));
        mediumLevel.addTag(new DefaultTagCloudItem("Model-driven Engineering", 2));
    }
    
    private void configLowLevel(){
        lowLevel.addTag(new DefaultTagCloudItem("Node.js", 2));
        lowLevel.addTag(new DefaultTagCloudItem("AngularJS", 4));
        lowLevel.addTag(new DefaultTagCloudItem("SLA", 2));
        lowLevel.addTag(new DefaultTagCloudItem("iOS", 2));
        lowLevel.addTag(new DefaultTagCloudItem("Android", 2));
        lowLevel.addTag(new DefaultTagCloudItem("C", 1));
        lowLevel.addTag(new DefaultTagCloudItem("C++", 1));
        lowLevel.addTag(new DefaultTagCloudItem("VBA", 1));
    }
    
    private void configInterests(){
        interests.addTag(new DefaultTagCloudItem("Continuous learning", 5));
        interests.addTag(new DefaultTagCloudItem("New technologies", 3));
        interests.addTag(new DefaultTagCloudItem("Networking", 2));
        interests.addTag(new DefaultTagCloudItem("Music", 4));
        interests.addTag(new DefaultTagCloudItem("Traveling", 3));
    }

    /**
     * @return the highLevel
     */
    public TagCloudModel getHighLevel() {
        return highLevel;
    }

    /**
     * @param highLevel the highLevel to set
     */
    public void setHighLevel(TagCloudModel highLevel) {
        this.highLevel = highLevel;
    }

    /**
     * @return the mediumLevel
     */
    public TagCloudModel getMediumLevel() {
        return mediumLevel;
    }

    /**
     * @param mediumLevel the mediumLevel to set
     */
    public void setMediumLevel(TagCloudModel mediumLevel) {
        this.mediumLevel = mediumLevel;
    }

    /**
     * @return the lowLevel
     */
    public TagCloudModel getLowLevel() {
        return lowLevel;
    }

    /**
     * @param lowLevel the lowLevel to set
     */
    public void setLowLevel(TagCloudModel lowLevel) {
        this.lowLevel = lowLevel;
    }

    /**
     * @return the interests
     */
    public TagCloudModel getInterests() {
        return interests;
    }

    /**
     * @param interests the interests to set
     */
    public void setInterests(TagCloudModel interests) {
        this.interests = interests;
    }
    
    public StreamedContent getCvFile() {
        return cvFile;
    }
}
