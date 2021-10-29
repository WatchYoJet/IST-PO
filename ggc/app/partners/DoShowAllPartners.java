package ggc.app.partners;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

import java.text.CollationElementIterator;
import java.util.Collection;

import ggc.core.Partner;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Show all partners.
 */
class DoShowAllPartners extends Command<WarehouseManager> {

  DoShowAllPartners(WarehouseManager receiver) {
    super(Label.SHOW_ALL_PARTNERS, receiver);
  }

  @Override
  public void execute() throws CommandException {
    //ADD TRY CATCH
    Collection <Partner> partners = _receiver.getPartner();
    for (Partner p : partners){
      _display.addLine(""+p.getID()+"|"
                        +p.getName()+"|"
                        +p.getAddress()+"|"
                        +p.getStatus()+"|"
                        +p.getPoints()+"|"
                        +Math.round(p.getBought())+"|"
                        +Math.round(p.getSellsDone())+"|"
                        +Math.round(p.getSellsPaid()));
    }
    _display.display();
  }
}
