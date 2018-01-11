/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gilangkw.latihanmvcjdbc.controller;

import edu.gilangkw.latihanmvcjdbc.model.PelangganModel;
import edu.gilangkw.latihanmvcjdbc.view.PelangganView;
import edu.gilangkw.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilang Kusuma Wijaya
 */
public class PelangganController {

    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }

    public void resetPelanggan(PelangganView view) {
        model.resetPelanggan();
    }

    public void insertPelanggan(PelangganView view) {
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]
                {"Terjadi error di database dengan pesan", e.getMessage()});
            }

        }
    }

    public void updatePelanggan(PelangganView view) {
        if (view.getTabelPelanggan().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silahkan selesi data yang akan diubah");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtID().getText());
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Diubah");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]
                {"Terjadi error di database dengan pesan", e.getMessage()});
            }

        }
    }

    public void deletePelanggan(PelangganView view) {
        if (view.getTabelPelanggan().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silahkan selesi data yang akan dihapus");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus?")== JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtID().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Dihapus");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]
                {"Terjadi error di database dengan pesan", e.getMessage()});
            }
        }
    }

}
