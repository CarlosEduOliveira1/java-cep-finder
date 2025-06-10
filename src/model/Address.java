package model;

public class Address {
   protected String postalCode;
   protected String street;
   protected String complement;
   protected String neighbourhood;
   protected String uf;
   protected String state;
   protected String region;
   protected String ibgeCode;
   protected String gia;
   protected String ddd;
   protected String siafi;

   public Address(
         String postalCode,
         String street,
         String complement,
         String neighbourhood,
         String uf,
         String state,
         String region,
         String ibgeCode,
         String gia,
         String ddd,
         String siafi) {
      this.postalCode = postalCode;
      this.street = street;
      this.complement = complement;
      this.neighbourhood = neighbourhood;
      this.uf = uf;
      this.state = state;
      this.region = region;
      this.ibgeCode = ibgeCode;
      this.gia = gia;
      this.ddd = ddd;
      this.siafi = siafi;
   }

   public Address(AddressViaCep addressViaCep) {
      this.postalCode = addressViaCep.postalCode();
      this.street = addressViaCep.street();
      this.complement = addressViaCep.complement();
      this.neighbourhood = addressViaCep.neighbourhood();
      this.uf = addressViaCep.uf();
      this.state = addressViaCep.state();
      this.region = addressViaCep.region();
      this.ibgeCode = addressViaCep.ibgeCode();
      this.gia = addressViaCep.gia();
      this.ddd = addressViaCep.ddd();
      this.siafi = addressViaCep.siafi();
   }

   public String getPostalCode() {
      return postalCode;
   }

   public String getStreet() {
      return street;
   }

   public String getComplement() {
      return complement;
   }

   public String getNeighbourhood() {
      return neighbourhood;
   }

   public String getUf() {
      return uf;
   }

   public String getState() {
      return state;
   }

   public String getRegion() {
      return region;
   }

   public void getAddressData() {
      System.out.println("Logradouro: " + street);
      System.out.println("Complemento: " + complement);
      System.out.println("Bairro: " +  neighbourhood);
      System.out.println("Estado" + uf);
      System.out.println("Cep: " + postalCode);
   }
}
