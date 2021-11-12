package ggc.app.lookups;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
import ggc.core.exception.UnknownKeyException;
import pt.tecnico.uilib.forms.Form;
import java.util.Collection;

import ggc.app.exception.UnknownPartnerKeyException;
import ggc.core.Transaction;
//FIXME import classes

/**
 * Lookup payments by given partner.
 */
public class DoLookupPaymentsByPartner extends Command<WarehouseManager> {

  public DoLookupPaymentsByPartner(WarehouseManager receiver) {
    super(Label.PAID_BY_PARTNER, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException, UnknownPartnerKeyException {
    String id = Form.requestString(Message.requestPartnerKey());
    try{
      Collection<Transaction> transactions =  _receiver.showPartnerSalesPaid(id);
      for (Transaction transaction : transactions) {
        _display.addLine(transaction.toString());
      }
      _display.display();
    }catch(UnknownKeyException e){
      throw new UnknownPartnerKeyException(e.getId());
    }
  }

}
