package com.tngtech.jgiven.report.json;

import java.io.File;
import java.io.Reader;

import com.tngtech.jgiven.relocated.guava.base.Charsets;
import com.tngtech.jgiven.relocated.guava.base.Function;
import com.tngtech.jgiven.relocated.guava.base.Throwables;
import com.tngtech.jgiven.relocated.guava.io.Files;
import com.tngtech.jgiven.relocated.gson.Gson;
import com.tngtech.jgiven.impl.util.ResourceUtil;
import com.tngtech.jgiven.report.model.ReportModel;

public class ScenarioJsonReader implements Function<File, ReportModel> {
    @Override
    public ReportModel apply( File file ) {
        Reader reader = null;
        try {
            reader = Files.newReader( file, Charsets.UTF_8 );
            return new Gson().fromJson( reader, ReportModel.class );
        } catch( Exception e ) {
            throw Throwables.propagate( e );
        } finally {
            ResourceUtil.close( reader );
        }
    }
}
