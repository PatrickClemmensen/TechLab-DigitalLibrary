/**
 * Enum representing the available loan item types in the TechLab system.
 * Used by InputValidation.promptItemType() and LoanItemFactory.create()
 * to determine which LoanItem subclass to instantiate.
 * Add new values here when extending the system with additional item types.
 */
public enum ItemType {
    book,
    video,
    raspberry_pi,
    arduino_kit
}