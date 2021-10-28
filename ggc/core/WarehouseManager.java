package ggc.core;

//FIXME import classes (cannot import from pt.tecnico or ggc.app)

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import ggc.app.exception.InvalidDateException; //FIXME THIS IS WRONG
import ggc.core.exception.BadEntryException;
import ggc.core.exception.DuplicateKeyException;
import ggc.core.exception.ImportFileException;
import ggc.core.exception.UnavailableFileException;
import ggc.core.exception.MissingFileAssociationException;
import ggc.core.exception.UnknownKeyException;


/** Façade for access. */
public class WarehouseManager {

  /** Name of file storing current warehouse. */
  private String _filename = "";

  /** The wharehouse itself. */
  private Warehouse _warehouse = new Warehouse();

  //FIXME define other attributes
  //FIXME define constructor(s)
  //FIXME define other methods

  /**
   * @@throws IOException
   * @@throws FileNotFoundException
   * @@throws MissingFileAssociationException
   */

//-------------------------------------
  public Warehouse getWarehouse(){return _warehouse;}
//-------------------------------------

  public void registerPartner(String name, String address, String id) throws DuplicateKeyException{
    if (! _warehouse.checkPartnerID(id)){
      _warehouse.registerPartner(name, address, id);
      return;
    }
    throw new DuplicateKeyException();
    //ADD EXCEPTION
  }

  public Partner getPartner(String id) throws UnknownKeyException {
    if (_warehouse.checkPartnerID(id))return _warehouse.getPartner(id);
    throw new UnknownKeyException();
  }

  public Collection<Batch> getBatch(){return _warehouse.getBatch();}

  public Collection<Partner> getPartner(){return _warehouse.getPartner();}

  public Collection<SimpleProduct> getProduct(){return _warehouse.getProduct();}
//-------------------------------------
  public void addDate(int increment) throws InvalidDateException{
    if (increment < 0) throw new InvalidDateException(increment);
    _warehouse.addDate(increment);
  }
  
  public int getDate(){return _warehouse.getDate();}
//-------------------------------------
  
  public void save() throws IOException, FileNotFoundException, MissingFileAssociationException {
		ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(_filename));
		file.writeObject(_warehouse);
		file.close();
  }

  /**
   * @@param filename
   * @@throws MissingFileAssociationException
   * @@throws IOException
   * @@throws FileNotFoundException
   */
  public void saveAs(String filename) throws MissingFileAssociationException, FileNotFoundException, IOException {
    _filename = filename;
    save();
  }

  public String getFileName(){return _filename;}

  /**
   * @@param filename
   * @@throws UnavailableFileException
   */
  public void load(String filename) throws IOException, UnavailableFileException, ClassNotFoundException  {
    _filename = filename;
    ObjectInputStream file = new ObjectInputStream(new FileInputStream(filename));
		_warehouse = (Warehouse) file.readObject(); //casts the object of the file
    file.close();
  }

  /**
   * @param textfile
   * @throws ImportFileException
   */
  public void importFile(String textfile) throws ImportFileException {
    try {
      _warehouse.importFile(textfile);
    } catch (IOException | BadEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(textfile, e);
    }
  }
}