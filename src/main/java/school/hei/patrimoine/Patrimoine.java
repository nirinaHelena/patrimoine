package school.hei.patrimoine;

import school.hei.patrimoine.possession.Possession;

import java.time.Instant;
import java.util.Iterator;
import java.util.Set;

public record Patrimoine(
    Personne possesseur, Instant t, Set<Possession> possessions) {

  public int getValeurComptable() {
    if (possessions.isEmpty()) {
      return 0;
    }
    int valeurComptable = 0;
    Iterator<Possession> possessionIterator = possessions.iterator();
    while (possessionIterator.hasNext()){
      Possession possession = possessionIterator.next();
      valeurComptable += possession.getValeurComptable();
    }
    return valeurComptable;
  }
}
