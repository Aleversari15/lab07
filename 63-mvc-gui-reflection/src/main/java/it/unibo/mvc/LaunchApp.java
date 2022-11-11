package it.unibo.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {
    private static String STDOUT_VIEW = "it.unibo.mvc.view.DrawNumberStdoutView";
    private static String SWING_VIEW = "it.unibo.mvc.view.DrawNumberSwingView";

    private LaunchApp() {
    }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException    if the fetches class does not exist
     * @throws NoSuchMethodException     if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException    if the constructor throws exceptions
     * @throws IllegalAccessException    in case of reflection issues
     * @throws IllegalArgumentException  in case of reflection issues
     */
    public static void main(final String... args) throws
        ClassNotFoundException,
        NoSuchMethodException,
        InvocationTargetException,
        InstantiationException,
        IllegalAccessException,
        IllegalArgumentException {
            final var model = new DrawNumberImpl();
            final DrawNumberController app = new DrawNumberControllerImpl(model);
            final List<String> viewList = List.of(SWING_VIEW, STDOUT_VIEW);
            for (final var view : viewList) {
                final var viewClass = Class.forName(view);
                final var constructor = viewClass.getConstructor();
                for (int i = 0; i < 3; i++) {
                    app.addView((DrawNumberView) constructor.newInstance());
                }
            }
        }       
}