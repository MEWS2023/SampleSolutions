/**
 * generated by Xtext 2.31.0
 */
package ac.at.tuwien.big.formatting2;

import ac.at.tuwien.big.services.ScmlGrammarAccess;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import scml.Category;
import scml.InfrastructureComponent;
import scml.KPIMeasurementDevice;
import scml.Project;
import scml.SmartCity;

@SuppressWarnings("all")
public class ScmlFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private ScmlGrammarAccess _scmlGrammarAccess;

  protected void _format(final SmartCity smartCity, @Extension final IFormattableDocument document) {
    EList<Category> _category = smartCity.getCategory();
    for (final Category category : _category) {
      document.<Category>format(category);
    }
    EList<Project> _project = smartCity.getProject();
    for (final Project project : _project) {
      document.<Project>format(project);
    }
  }

  protected void _format(final Project project, @Extension final IFormattableDocument document) {
    EList<InfrastructureComponent> _component = project.getComponent();
    for (final InfrastructureComponent infrastructureComponent : _component) {
      document.<InfrastructureComponent>format(infrastructureComponent);
    }
    EList<KPIMeasurementDevice> _indicator = project.getIndicator();
    for (final KPIMeasurementDevice kPIMeasurementDevice : _indicator) {
      document.<KPIMeasurementDevice>format(kPIMeasurementDevice);
    }
  }

  public void format(final Object project, final IFormattableDocument document) {
    if (project instanceof XtextResource) {
      _format((XtextResource)project, document);
      return;
    } else if (project instanceof Project) {
      _format((Project)project, document);
      return;
    } else if (project instanceof SmartCity) {
      _format((SmartCity)project, document);
      return;
    } else if (project instanceof EObject) {
      _format((EObject)project, document);
      return;
    } else if (project == null) {
      _format((Void)null, document);
      return;
    } else if (project != null) {
      _format(project, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(project, document).toString());
    }
  }
}
