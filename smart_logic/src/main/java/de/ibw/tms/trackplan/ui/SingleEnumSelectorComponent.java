package de.ibw.tms.trackplan.ui;

import de.ibw.tms.trackplan.EnumModel;
import de.ibw.tms.trackplan.controller.Intf.IController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleEnumSelectorComponent<T extends EnumModel> extends JComboBox {





    private IController C;

    private T ViewModel = null;

    public SingleEnumSelectorComponent(T SelectionModel, IController C) {
        super();
        // viewmodel transmitted by controller
        this.ViewModel = SelectionModel;
        // combobox View model
        this.setModel(new DefaultComboBoxModel<EnumModel.EnumField>(this.ViewModel.getEnumMappingList()));

        this.C = C;


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
    public void update(Enum Selected) {
        EnumModel.EnumField[] fields = this.ViewModel.getEnumMappingList();
        EnumModel.EnumField Field = this.ViewModel.getFieldByDataEnum(Selected);
        if(null != Field) {
            this.setSelectedItem(Field);
            this.ViewModel.setSingleSelection(Field);
        }



    }

    public void publish() {
        this.C.publish();
    }





}
