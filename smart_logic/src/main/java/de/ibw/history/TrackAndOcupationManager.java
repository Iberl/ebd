package de.ibw.history;

import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TrackAndOcupationManager {
    private static ThreadedRepo<Class<?>, ThreadedRepo<TrackEdge, ArrayList<?>>> Storage = new ThreadedRepo<>();





}
