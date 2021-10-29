package ggc.core;

// FIXME import classes (cannot import from pt.tecnico or ggc.app)

import java.io.Serializable;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import ggc.core.Batch;
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
  private Map<String,AggregateProduct> _aggregateProducts;

  public Warehouse (){
    _date = new Date();
    _partners = new TreeMap<String, Partner>(String.CASE_INSENSITIVE_ORDER);
    _batches = new ArrayList<Batch>();
    _simpleProducts = new TreeMap<String,SimpleProduct>(String.CASE_INSENSITIVE_ORDER);
  }

  public boolean checkPartnerID(String id){return _partners.containsKey(id);}

  
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

  private Collection<String> getBatchesNames(){
    List<String> names = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      names.add(itr.next().getProduct().getID());
    }
    return names;
  }

  private Collection<String> getBatchesPartnersNames(){
    List<String> partners = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      partners.add(itr.next().getPartner());
    }
    return partners;
  }

  private Collection<Double> getBatchesPrices(){
    List<Double> prices = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      prices.add(itr.next().getPrice());
    }
    return prices;
  }

  private Collection<Integer> getBatchesQuantity(){
    List<Integer> quantity = new ArrayList<>();
    Iterator<Batch> itr=_batches.iterator();  
    while(itr.hasNext()){  
      quantity.add(itr.next().getQuantity());
    }
    return quantity;
  }

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

  public Collection<SimpleProduct> getProduct(){return _simpleProducts.values();}

  public Collection<Partner> getPartner(){return _partners.values();}

  public Partner getPartner(String id){return _partners.get(id);}

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
