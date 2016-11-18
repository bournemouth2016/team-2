class CreateBoats < ActiveRecord::Migration[5.0]
  def change
    create_table :boats do |t|
      t.string :moore
      t.integer :passenger
      t.string :phone
      t.string :size

      t.timestamps
    end
  end
end
