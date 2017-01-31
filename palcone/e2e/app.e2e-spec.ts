import { PalconePage } from './app.po';

describe('palcone App', function() {
  let page: PalconePage;

  beforeEach(() => {
    page = new PalconePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
