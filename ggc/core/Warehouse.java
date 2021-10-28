package ggc.core;

// FIXME import classes (cannot import from pt.tecnico or ggc.app)

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import ggc.core.Batch;
import ggc.core.Partner;
import ggc.core.Product;
import ggc.core.exception.BadEntryException;
import ggc.core.exception.UnknownKeyException;

/**
 * Class Warehouse implements a warehouse.
 */
public class Warehouse implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202109192006L;
  private Date _date;
  private TreeMap<String, Partner> _partners;
  private ArrayList<Batch> _batches;
  private TreeMap<String,SimpleProduct> _simpleProducts;
  private TreeMap<String,AggregateProduct> _aggregateProducts;

  public Warehouse (){
    _date = new Date();
    _partners = new TreeMap<String, Partner>(String.CASE_INSENSITIVE_ORDER);
    _batches = new ArrayList<Batch>();
    _simpleProducts = new TreeMap<String,SimpleProduct>(String.CASE_INSENSITIVE_ORDER);
  }

  public boolean checkPartnerID(String id){return _partners.containsKey(id);}

  /*
  public void registerBatchAggregate(Product p, double price, int quantity, Partner partner){
    Batch b = new Batch(p, price, quantity, partner);
    b.setAggregateProduct();
    _batches.add(b);
  }*/

  
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
  
  public void registerPartner(String name, String address, String id){
    _partners.put(id, new Partner(name, address, id));
  }

  public Collection<Batch> getBatch(){return _batches;}

  public SimpleProduct getProduct(String name){return _simpleProducts.get(name);}

  public Collection<SimpleProduct> getProduct(){return _simpleProducts.values();}

  public Collection<Partner> getPartner(){return _partners.values();}

  public Partner getPartner(String id){return _partners.get(id);}

  public int getDate(){return _date.getDays();}

  public void addDate(int increment){_date.add(increment);}
  
  // FIXME define attributes
  // FIXME define contructor(s)
  // FIXME define methods

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  void importFile(String txtfile) throws IOException, BadEntryException /* FIXME maybe other exceptions */ {
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

}
