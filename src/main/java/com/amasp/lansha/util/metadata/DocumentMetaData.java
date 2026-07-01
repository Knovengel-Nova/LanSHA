package com.amasp.lansha.util.metadata;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

/**
 *
 * @author knovengel
 */
public class DocumentMetaData extends FileMetaData {

    /* ---------- Preview ---------- */
    private BufferedImage preview;

    /* ---------- Basic Document Info ---------- */
    private String title;
    private String author;
    private String subject;
    private String keywords;
    private String language;
    private String description;

    /* ---------- Statistics ---------- */
    private Integer pageCount;
    private Integer wordCount;
    private Integer characterCount;
    private Integer lineCount;
    private Integer paragraphCount;

    /* ---------- Technical ---------- */
    private String application;
    private String creator;
    private String producer;
    private String company;
    private String version;
    private Boolean encrypted;

    public DocumentMetaData(Path path) {
        super(path);
    }

    /* ---------- Helper ---------- */
    public boolean hasDocumentMetaData() {
        return title != null
                || author != null
                || subject != null
                || creator != null
                || producer != null
                || application != null;
    }

    /* ---------- Getters / Setters ---------- */
    public BufferedImage getPreview() {
        return preview;
    }

    public void setPreview(BufferedImage preview) {
        this.preview = preview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Integer getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(Integer characterCount) {
        this.characterCount = characterCount;
    }

    public Integer getLineCount() {
        return lineCount;
    }

    public void setLineCount(Integer lineCount) {
        this.lineCount = lineCount;
    }

    public Integer getParagraphCount() {
        return paragraphCount;
    }

    public void setParagraphCount(Integer paragraphCount) {
        this.paragraphCount = paragraphCount;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

}
