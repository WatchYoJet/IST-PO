package ggc.core;

import java.io.File;
import java.io.IOException;

// FIXME import classes (cannot import from pt.tecnico or ggc.app)

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import ggc.core.exception.BadEntryException;

/**
 * Class Warehouse implements a warehouse.
 */
public class Warehouse implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202109192006L;
  private Date _date;
  private Map<String, Partner> _partners;
  private List<Batch> _batches;
  private Map<String,SimpleProduct> _simpleProducts;
  private Map<Integer,Transaction> _transactions;
  private double _balance;
  private double _realBalance;
  private int _nextTransactionId;

  /**
   * Cunstructor
   */
  public Warehouse (){
    _date = new Date();
    _partners = new TreeMap<String, Partner>(String.CASE_INSENSITIVE_ORDER);
    _batches = new ArrayList<Batch>();
    _simpleProducts = new TreeMap<String,SimpleProduct>(String.CASE_INSENSITIVE_ORDER);
    _transactions = new TreeMap<Integer,Transaction>();
    _balance = 0;
    _realBalance = 0;
    _nextTransactionId = 0;
  }

  /**
   * @param id identifier of the requested partner
   * @return returns a boolean to check if the partner exists
   */
  public boolean checkPartnerID(String id){return _partners.containsKey(id);}


  /**
   * @param name of the product
   * @param price of the product
   * @param quantity of the giving product
   * @param partnerName of the partner
   */
  public void registerBatchSimple(String name,
                                  String price, 
                                  String quantity, 
                                  String partnerName){
    if (_simpleProducts.containsKey(name)){
      SimpleProduct product = _simpleProducts.get(name);
      product.setNewMaxPrice(Double.parseDouble(price));
      product.changeQuantity(Integer.parseInt(quantity));
      Batch batch = new Batch(product, price, quantity, partnerName);
      _batches.add(batch);
    }else{
      SimpleProduct product = new SimpleProduct(name, price, quantity);
      _simpleProducts.put(name, product);
      Batch batch = new Batch(product, price, quantity, partnerName);
      _batches.add(batch);
    }
  }
  
  /**
   * @param name of the partner
   * @param address of the partner
   * @param id of the partner
   */
  public void registerPartner(String name, String address, String id){
    _partners.put(id, new Partner(name, address, id));
  }

  public SimpleProduct registerSimpleProduct(String name, String price, String quantity){
    _simpleProducts.put(name, new SimpleProduct(name, price, quantity));
    return _simpleProducts.get(name);
  }

  public void registerBatch(Product product, String price, String quantity, String partnerName){
    Batch batch = new Batch(product, price, quantity, partnerName);
    _batches.add(batch);
  }

  /**
   * @return returns a list of all the current names
   */
  private Collection<String> getBatchesNames(){
    List<String> names = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      names.add(itr.next().getProduct().getID());
    }
    return names;
  }

  /**
   * @return returns a list of all the current partners
   */
  private Collection<String> getBatchesPartnersNames(){
    List<String> partners = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      partners.add(itr.next().getPartner());
    }
    return partners;
  }

  /**
   * @return returns a list of all the current prices
   */
  private Collection<Double> getBatchesPrices(){
    List<Double> prices = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      prices.add(itr.next().getPrice());
    }
    return prices;
  }

  /**
   * @return returns a list of all the current quantities
   */
  private Collection<Integer> getBatchesQuantity(){
    List<Integer> quantity = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      quantity.add(itr.next().getQuantity());
    }
    return quantity;
  }


  /**
   * @return all the batches stored in order
   */
  public Collection<Batch> getBatch(){
    List<String> names = new ArrayList<String>(getBatchesNames());
    List<String> partners = new ArrayList<String>(getBatchesPartnersNames());
    List<Double> prices = new ArrayList<Double>(getBatchesPrices());
    List<Integer> quantity = new ArrayList<Integer>(getBatchesQuantity());
    Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
    Collections.sort(partners, String.CASE_INSENSITIVE_ORDER);
    Collections.sort(prices);
    Collections.sort(quantity);

    List<Batch> batches = new ArrayList<>();

    for(String name : names){
      for (String partner : partners){
        for (double price : prices){
          for (int quant : quantity){
            for(Batch batch : _batches){
              boolean nameComp = batch.getProduct().getID().toLowerCase().equals(
                        name.toLowerCase());
              boolean partnerComp = batch.getPartner().toLowerCase().equals(
                        partner.toLowerCase());
              if (nameComp 
              && partnerComp 
              && batch.getPrice() == price 
              && batch.getQuantity() == quant
              && !batches.contains(batch)){
                batches.add(batch);
              }
            }
          }
        }
      }
    }
    return batches;
  }

  public SimpleProduct getProduct(String name){return _simpleProducts.get(name);}

  /**
   * @return returns all the stored Products
   */
  public Collection<SimpleProduct> getProduct(){return _simpleProducts.values();}


  public Boolean checkProduct(String name){return _simpleProducts.containsKey(name);}

  /**
   * @return all the Batches given by the partner
   */
  public Collection<Batch> getBatchesByPartner(String id){
    List<Batch> batches = new ArrayList<>();
    for(Batch batch : _batches){
      if (batch.getPartner().equals(id)){
        batches.add(batch);
      }
    }
    return batches;
  }

  public Collection<Batch> getBatchesByProduct(String productId){
    List<Batch> batches = new ArrayList<>();

    for(Batch batch : _batches){
      if (batch.getProduct().getID().equals(productId)){
        batches.add(batch);
      }
    }
    return batches;
  }


  /**
   * @return returns all the stored partners
   */
  public Collection<Partner> getPartner(){return _partners.values();}

  /**
   * @param id identifier of the requested partner
   * @return returns the partner of the giving ID
   */
  public Partner getPartner(String id){return _partners.get(id);}

  /**
   * @return the current date in int
   */
  public int getDate(){return _date.getDays();}

  /**
   * @param increment integer to be added to the _date variable.
   */
  public void addDate(int increment){_date.add(increment);}

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  void importFile(String txtfile) throws IOException, BadEntryException {
    File file = new File(txtfile);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] scrape = line.split("\\|");
      switch (scrape[0]) {
        case "PARTNER":
          this.registerPartner(scrape[2], scrape[3], scrape[1]);
          break;
        case "BATCH_S":
          this.registerBatchSimple(scrape[1], scrape[3], scrape[4], scrape[2]);
          break;
        default:
          break;
      }
    }
    scanner.close();
  }

  public Collection<Batch> lookupProductBatchesUnderGivenPrice(Double price) {
    List<Batch> batches = new ArrayList<>(getBatch());
    for(Batch batch : _batches){
      if (batch.getPrice() > price){
        batches.remove(batch);
      }
    }
    return batches;
  }

  public double getBalance() {
      return _balance;
  }

  public double getRealBalance() {
    return _realBalance;
  }

  public void changeRealBalance(double amount) {
    _realBalance += amount;
  }
  
  public void changeBalance(double amount) {
    _balance += amount;
  }

  public void acquisition(String productID, String quantity, String partnerID, String price) {
    if (checkProduct(productID)) {
      SimpleProduct product = getProduct(productID);
      product.setNewMaxPrice(Integer.parseInt(price));
      product.changeQuantity(Integer.parseInt(quantity));
      registerBatch(product, quantity, price, partnerID);
    }else{
      SimpleProduct product = registerSimpleProduct(productID, price, quantity);
      registerBatch(product, quantity, price, partnerID);
    }
    if (getPartner(partnerID) == null) {
      registerPartner(partnerID, price, productID);
    }
    changeBalance(-(Double.parseDouble(price) * Integer.parseInt(quantity)));
    changeRealBalance(-(Double.parseDouble(price) * Integer.parseInt(quantity)));
    if (getPartner(partnerID) != null)
      getPartner(partnerID).changeBought(Double.parseDouble(price) * Integer.parseInt(quantity));
    Transaction transaction = new Acquisition(_nextTransactionId, getDate(), Double.parseDouble(price) * Integer.parseInt(quantity),
                              Integer.parseInt(quantity), getProduct(productID), getPartner(partnerID));
    _transactions.put(_nextTransactionId, transaction);
    _nextTransactionId++;
  }

  public boolean checkTransactionID(Integer transactionID) {
    return _transactions.containsKey(transactionID);
  }

  public Transaction getTransaction(Integer transactionID) {
    return _transactions.get(transactionID);
  }
  
}
