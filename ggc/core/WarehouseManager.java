package ggc.core;

//FIXME import classes (cannot import from pt.tecnico or ggc.app)

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ggc.core.exception.BadEntryException;
import ggc.core.exception.DuplicateKeyException;
import ggc.core.exception.ImportFileException;
import ggc.core.exception.InvalidDateValueException;
import ggc.core.exception.UnavailableFileException;
import ggc.core.exception.MissingFileAssociationException;
import ggc.core.exception.UnknownKeyException;


/** Façade for access. */
public class WarehouseManager {

  /** Name of file storing current warehouse. */
  private String _filename = "";

  /** The wharehouse itself. */
  private Warehouse _warehouse = new Warehouse();

  /**
   * @@throws IOException
   * @@throws FileNotFoundException
   * @@throws MissingFileAssociationException
   */

  /**
   * @return the current WareHouse
   */
  public Warehouse getWarehouse(){return _warehouse;}

  /**
   * @param name of the new Partner
   * @param address of the new Partner
   * @param id of the new Partner
   */
  public void registerPartner(String name, String address, String id) throws DuplicateKeyException{
    if (! _warehouse.checkPartnerID(id)){
      _warehouse.registerPartner(name, address, id);
      return;
    }
    throw new DuplicateKeyException(id);
    //ADD EXCEPTION
  }
  /**
   * @param id of the requested Partner
   * @return the Partner requested
   */
  public Partner getPartner(String id) throws UnknownKeyException {
    if (_warehouse.checkPartnerID(id))return _warehouse.getPartner(id);
    throw new UnknownKeyException(id);
  }
  /**
   * @return all the Batches stored
   */
  public Collection<Batch> getBatch(){return _warehouse.getBatch();}
  /**
   * @return all the Partners stored
   */
  public Collection<Partner> getPartner(){return _warehouse.getPartner();}
  /**
   * @return all the Products stored
   */
  public Collection<SimpleProduct> getProduct(){return _warehouse.getProduct();}
//-------------------------------------
  /**
   * @@param increment of the current date
   * @@throws InvalidDateValueException
   */
  public void addDate(int increment) throws InvalidDateValueException{
    if (increment < 0) throw new InvalidDateValueException(increment);
    _warehouse.addDate(increment);
  }
  
  public int getDate(){return _warehouse.getDate();}
//-------------------------------------
  /**
   * @@throws IOException
   * @@throws FileNotFoundException
   * @@throws MissingFileAssociationException
   */
  public void save() throws IOException, FileNotFoundException, MissingFileAssociationException {
    FileOutputStream fileOutPut = new FileOutputStream(_filename);
		ObjectOutputStream file = new ObjectOutputStream(fileOutPut);
		file.writeObject(_warehouse);
		file.close();
    fileOutPut.close();
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

  public Collection<Batch> getBatchesByProduct(String productID) throws UnknownKeyException {
    if (_warehouse.checkProduct(productID))return _warehouse.getBatchesByProduct(productID);
    throw new UnknownKeyException(productID);
  }

  public Collection<Batch> getBatchesByPartner(String partnerID) throws UnknownKeyException {
    if (_warehouse.checkPartnerID(partnerID))return _warehouse.getBatchesByPartner(partnerID);
    throw new UnknownKeyException(partnerID);
  }

  public Collection<Batch> lookupProductBatchesUnderGivenPrice(Double price){
    return _warehouse.lookupProductBatchesUnderGivenPrice(price);
  }

  public String getFileName(){return _filename;}

  /**
   * @@param filename
   * @@throws UnavailableFileException
   */
  public void load(String filename) throws IOException, UnavailableFileException, ClassNotFoundException  {
    _filename = filename;
    FileInputStream fileOutPut = new FileInputStream(filename);
    ObjectInputStream file = new ObjectInputStream(fileOutPut);
		_warehouse = (Warehouse) file.readObject(); //casts the object of the file
    file.close();
    fileOutPut.close();
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

  public double getBalance() {
    return _warehouse.getBalance();
  }

  public double getRealBalance() {
    return _warehouse.getRealBalance();
  }

  public void acquisition(String productID, String quantity, String partnerID, String price){
    _warehouse.acquisition(productID, quantity, partnerID, price);
  }

  public void sale(String productID, String quantity, String partnerID, Integer days){
    _warehouse.sale(productID, quantity, partnerID, days);
  }

  public Transaction getTransaction(Integer id) throws UnknownKeyException {
    if (!_warehouse.checkTransactionID(id))throw new UnknownKeyException(id.toString());
    return _warehouse.getTransaction(id);
  }

  public Collection<Transaction> showPartnerAcquisitions(String id) throws UnknownKeyException {
    if (!_warehouse.checkPartnerID(id))throw new UnknownKeyException(id);
    return _warehouse.showPartnerAcquisitions(id);
  }

  public void toggleNotification(String productID, String partnerID) throws UnknownKeyException{
    if (_warehouse.getProduct(productID) == null)throw new UnknownKeyException(productID);
    if (_warehouse.getPartner(partnerID) == null)throw new UnknownKeyException(partnerID);
    System.out.println(_warehouse.getProduct(productID).getID());
    _warehouse.toggleNotification(productID, partnerID);
  }

  public Collection<Notification> getNotifications(String partnerID){
    return _warehouse.getNotifications(partnerID);
  }

  public void clearNotifications(String partnerID){
    _warehouse.clearNotifications(partnerID);
  }

  public void receivePayment(Integer id) throws UnknownKeyException{
    if (!_warehouse.checkTransactionID(id))throw new UnknownKeyException(id.toString());
    _warehouse.receivePayment(id);
  }

  public Collection<Transaction> showPartnerSales(String id) throws UnknownKeyException {
    if (!_warehouse.checkPartnerID(id))throw new UnknownKeyException(id);
    return _warehouse.showPartnerSales(id);
  }

  public Collection<Transaction> showPartnerSalesPaid(String id) throws UnknownKeyException {
    if (!_warehouse.checkPartnerID(id))throw new UnknownKeyException(id);
    return _warehouse.showPartnerSalesPaid(id);
  }
}