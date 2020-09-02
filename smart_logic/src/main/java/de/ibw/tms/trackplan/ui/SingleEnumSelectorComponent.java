package de.ibw.tms.trackplan.ui;

import de.ibw.tms.trackplan.EnumModel;
import de.ibw.tms.trackplan.controller.Intf.IController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allgemeine Kompontente zum &Auml;ndern von Enums.
 * Wird derzeit nur bei den Weichen eingesetzt.
 * Verwaltet Enum-Werte in einer Combobox.
 * @param <T> {@link EnumModel} - Art des verwalteten Enums.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 *  @since 2020-08-12
 */
public class SingleEnumSelectorComponent<T extends EnumModel> extends JComboBox {





    private IController C;

    private T ViewModel = null;

    /**
     * Initiert Komponente, wenn ein Fenster den Weichenstatus setzt
     * @param SelectionModel - Modell des Enums
     * @param C - Gibt gesetzte Werte an alle registrierten Komponenten weiter.
     */
    public SingleEnumSelectorComponent(T SelectionModel, IController C, boolean isDefaultAction) {
        super();
        // viewmodel transmitted by controller
        this.ViewModel = SelectionModel;
        // combobox View model
        this.setModel(new DefaultComboBoxModel<EnumModel.EnumField>(this.ViewModel.getEnumMappingList()));

        this.C = C;

        if(isDefaultAction) {
            addDefaultListener();
        }


    }



    public void addDefaultListener() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ///System.out.println("Action fired");
                Object OEnumField = SingleEnumSelectorComponent.this.getSelectedItem();
                System.out.println("Before enum");
                if(OEnumField == null) { return;}
                else {
                    SingleEnumSelectorComponent.this.ViewModel.setSingleSelection((EnumModel.EnumField) OEnumField);
                    SingleEnumSelectorComponent.this.publish();

                }
                // System.out.println("After enum");

            }
        });
    }

    /**
     * Setzt den Status des Enums, weil das Enum eventuell an einer anderen Stelle gesetzt wurde.
     * @param Selected {@link Enum} - gesetzter Wert des enums
     */
    public void update(Enum Selected) {
        EnumModel.EnumField[] fields = this.ViewModel.getEnumMappingList();
        EnumModel.EnumField Field = this.ViewModel.getFieldByDataEnum(Selected);
        if(null != Field) {
            this.setSelectedItem(Field);
            this.ViewModel.setSingleSelection(Field);
        }



    }

    private void publish() {
        this.C.publish();
    }





}
