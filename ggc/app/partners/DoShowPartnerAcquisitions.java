package ggc.app.partners;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

import java.util.Collection;

import ggc.core.Transaction;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Show all transactions for a specific partner.
 */
class DoShowPartnerAcquisitions extends Command<WarehouseManager> {

  DoShowPartnerAcquisitions(WarehouseManager receiver) {
    super(Label.SHOW_PARTNER_ACQUISITIONS, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException {
    String id = Form.requestString(Message.requestPartnerKey());

    Collection<Transaction> transactions =  _receiver.showPartnerAcquisitions(id);
    for (Transaction transaction : transactions) {
      _display.addLine(transaction.toString());
    }
    _display.display();
  }
}
