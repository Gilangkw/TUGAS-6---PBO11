/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gilangkw.latihanmvcjdbc.event;

import edu.gilangkw.latihanmvcjdbc.entity.Pelanggan;
import edu.gilangkw.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author Gilang Kusuma Wijaya
 */
public interface PelangganListener {
    public void onChange(PelangganModel model);
    public void onInsert(Pelanggan pelanggan);
    public void onDelete();
    public void onUpdate(Pelanggan pelanggan);
    
}
