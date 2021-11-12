package ggc.app.partners;

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
 * Show all transactions for a specific partner.
 */
class DoShowPartnerSales extends Command<WarehouseManager> {

  DoShowPartnerSales(WarehouseManager receiver) {
    super(Label.SHOW_PARTNER_SALES, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException, UnknownPartnerKeyException {
    String id = Form.requestString(Message.requestPartnerKey());
    try{
      Collection<Transaction> transactions =  _receiver.showPartnerSales(id);
      for (Transaction transaction : transactions) {
        _display.addLine(transaction.toString());
      }
      _display.display();
    }catch(UnknownKeyException e){
      throw new UnknownPartnerKeyException(e.getId());
    }
  }
}

