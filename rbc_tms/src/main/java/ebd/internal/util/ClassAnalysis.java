package ebd.internal.util;

import ebd.internal.util.annotations.CanBeNull;
import ebd.internal.util.annotations.MinOneElem;
import ebd.internal.util.exception.MissingInformationException;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Static Functions For The Analysis Of Classes And Their Values
 *
 * @author Christopher Bernjus
 */
public class ClassAnalysis {

    /**
     * Checks The Given Object On: <br>
     *     - Only Only Accordingly Annotated Fields Can Hold The Null Value <br>
     *     - Lists Must Have A Minimum Of 1 Element
     *
     * @param obj The Object To Analyse
     * @throws MissingInformationException One Of The Criteria Above Isn't Satisfied
     *
     * @author Christopher Bernjus
     */
    public static void checkValues(Object obj) throws MissingInformationException {

        // Get Fields Of Class
        Field[] fields = obj.getClass().getFields();

        for(Field field : fields) {
            try {
                Object value = field.get(obj);

                if(value == null) {
                    if(field.isAnnotationPresent(CanBeNull.class)) {
                        if(Constants.debug) System.out.println("The field "+ field.getName() + "has a null value.");
                    } else {
                        throw new MissingInformationException("The field " + field.getName() + " cannot be set to null.");
                    }
                }

                if(List.class.isAssignableFrom(value.getClass())) {
                    if(field.isAnnotationPresent(MinOneElem.class) && ((List) value).size() < 1) {
                        throw new MissingInformationException("The field " + field.getName() + "must have at least one element.");
                    }

                    // Check List Elements
                    for(Object item : (List<?>) value) {
                        checkValues(item);
                    }
                }

                if(Object.class.isAssignableFrom(value.getClass())) {
                    checkValues(obj);
                }

            } catch(IllegalAccessException e) {
                System.out.println("The field " + field.getName() + " could not be accessed");
                e.printStackTrace();
            }
        }

    }

}
